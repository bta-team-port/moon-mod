package teamport.moonmod.world.chunk;

import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.generate.LargeFeature;
import net.minecraft.core.world.generate.chunk.ChunkGeneratorResult;

import java.util.Random;

public class CavesLargeFeatureMoon extends LargeFeature {
    private final int minY;
    private final int maxY;

    public CavesLargeFeatureMoon() {
        this.minY = 0;
        this.maxY = 256;
    }

    protected void generateHubRoom(long seed, int baseChunkX, int baseChunkZ, ChunkGeneratorResult result, double blockX, double blockY, double blockZ) {
        this.generateCave(seed, baseChunkX, baseChunkZ, result, blockX, blockY, blockZ, 1.0F + rand.nextFloat() * 6.0F, 0.0F, 0.0F, -1, -1, 0.5);
    }

    protected void generateCave(long seed, int baseChunkX, int baseChunkZ, ChunkGeneratorResult result, double blockX, double blockY, double blockZ, float initialRadius, float yRot, float xRot, int startPos, int endPos, double heightMod) {
        double chunkMiddleX = baseChunkX * 16 + 8;
        double chunkMiddleZ = baseChunkZ * 16 + 8;
        float rotHorOffset = 0.0F;
        float rotVerOffset = 0.0F;
        Random random = new Random(seed);
        if (endPos <= 0) {
            int maxLength = this.radiusChunk * 16 - 16;
            endPos = maxLength - random.nextInt(maxLength / 4);
        }

        boolean noBranches = false;
        if (startPos == -1) {
            startPos = endPos / 2;
            noBranches = true;
        }

        int branchPos = random.nextInt(endPos / 2) + endPos / 4;

        for (boolean sharpRotVer = random.nextInt(6) == 0; startPos < endPos; ++startPos) {
            double width = 1.5 + (double) (MathHelper.sin((float) startPos * 3.1415927F / (float) endPos) * initialRadius * 1.0F);
            double height = width * heightMod;
            float xzScale = MathHelper.cos(xRot);
            float yOffset = MathHelper.sin(xRot);
            blockX += MathHelper.cos(yRot) * xzScale;
            blockY += yOffset;
            blockZ += MathHelper.sin(yRot) * xzScale;
            if (sharpRotVer) {
                xRot *= 0.92F;
            } else {
                xRot *= 0.7F;
            }

            xRot += rotVerOffset * 0.1F;
            yRot += rotHorOffset * 0.1F;
            rotVerOffset *= 0.9F;
            rotHorOffset *= 0.75F;
            rotVerOffset += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0F;
            rotHorOffset += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0F;
            if (!noBranches && startPos == branchPos && initialRadius > 1.0F) {
                this.generateCave(random.nextLong(), baseChunkX, baseChunkZ, result, blockX, blockY, blockZ, random.nextFloat() * 0.5F + 0.5F, yRot - 1.5707964F, xRot / 3.0F, startPos, endPos, 1.0);
                this.generateCave(random.nextLong(), baseChunkX, baseChunkZ, result, blockX, blockY, blockZ, random.nextFloat() * 0.5F + 0.5F, yRot + 1.5707964F, xRot / 3.0F, startPos, endPos, 1.0);
                return;
            }

            if (noBranches || random.nextInt(4) != 0) {
                double dxFromMiddle = blockX - chunkMiddleX;
                double dzFromMiddle = blockZ - chunkMiddleZ;
                double length = endPos - startPos;
                double maxRadius = initialRadius + 2.0F + 16.0F;
                if (dxFromMiddle * dxFromMiddle + dzFromMiddle * dzFromMiddle - length * length > maxRadius * maxRadius) {
                    return;
                }

                if (!(blockX < chunkMiddleX - 16.0 - width * 2.0) && !(blockZ < chunkMiddleZ - 16.0 - width * 2.0) && !(blockX > chunkMiddleX + 16.0 + width * 2.0) && !(blockZ > chunkMiddleZ + 16.0 + width * 2.0)) {
                    int minX = MathHelper.floor(blockX - width) - baseChunkX * 16 - 1;
                    int maxX = MathHelper.floor(blockX + width) - baseChunkX * 16 + 1;
                    int minYY = MathHelper.floor(blockY - height) - 1;
                    int maxYY = MathHelper.floor(blockY + height) + 1;
                    int minZ = MathHelper.floor(blockZ - width) - baseChunkZ * 16 - 1;
                    int maxZ = MathHelper.floor(blockZ + width) - baseChunkZ * 16 + 1;
                    if (minX < 0) {
                        minX = 0;
                    }

                    if (maxX > 16) {
                        maxX = 16;
                    }

                    if (minYY < this.minY + 1) {
                        minYY = this.minY + 1;
                    }

                    if (maxYY > this.maxY - 8) {
                        maxYY = this.maxY - 8;
                    }

                    if (minZ < 0) {
                        minZ = 0;
                    }

                    if (maxZ > 16) {
                        maxZ = 16;
                    }

                    if (this.worldObj.getWorldType().getOceanBlockId() != 0) {
                        boolean hasHitOcean = false;

                        for (int x = minX; !hasHitOcean && x < maxX; ++x) {
                            for (int z = minZ; !hasHitOcean && z < maxZ; ++z) {
                                for (int y = maxYY + 1; !hasHitOcean && y >= minYY - 1; --y) {
                                    int blockId = result.getBlock(x, y, z);
                                    if (y >= this.minY && y < this.maxY) {
                                        if (blockId == this.worldObj.getWorldType().getOceanBlockId()) {
                                            hasHitOcean = true;
                                        }

                                        if (y != minYY - 1 && x != minX && x != maxX - 1 && z != minZ && z != maxZ - 1) {
                                            y = minYY;
                                        }
                                    }
                                }
                            }
                        }

                        if (hasHitOcean) {
                            continue;
                        }
                    }

                    for (int x = minX; x < maxX; ++x) {
                        double xPercentage = ((double) (x + baseChunkX * 16) + 0.5 - blockX) / width;

                        for (int z = minZ; z < maxZ; ++z) {
                            double zPercentage = ((double) (z + baseChunkZ * 16) + 0.5 - blockZ) / width;
                            boolean replaceTopBlock = false;
                            for (int yy = maxYY; yy >= minYY; --yy) {
                                double yPercentage = ((double) yy + 0.5 - blockY) / height;
                                if (yPercentage > -0.7 && xPercentage * xPercentage + yPercentage * yPercentage + zPercentage * zPercentage < 1.0) {
                                    int blockId = result.getBlock(x, yy, z);
                                    if (Blocks.hasTag(blockId, BlockTags.CAVE_GEN_REPLACES_SURFACE)) {
                                        replaceTopBlock = true;
                                    }

                                    if (Blocks.hasTag(blockId, BlockTags.CAVES_CUT_THROUGH)) {
                                        if (yy < 10) {
                                            result.setBlock(x, yy, z, Blocks.OBSIDIAN.id());
                                        } else {
                                            result.setBlock(x, yy, z, 0);
                                            if (replaceTopBlock) {
                                                int worldX = x + baseChunkX * 16;
                                                int worldY = yy - 1;
                                                int worldZ = z + baseChunkZ * 16;
                                                Biome biome = this.worldObj.getBlockBiome(worldX, worldY, worldZ);
                                                int topBlockId = biome.topBlock;
                                                int fillBlockId = biome.fillerBlock;
                                                int id = result.getBlock(x, yy - 1, z);
                                                if (id == fillBlockId) {
                                                    result.setBlock(x, yy - 1, z, topBlockId);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (noBranches) {
                        break;
                    }
                }
            }
        }

    }

    protected void doGeneration(World world, int chunkX, int chunkZ, int baseChunkX, int baseChunkZ, ChunkGeneratorResult result) {
        this.worldObj = world;
        int cavesToGenerate = rand.nextInt(rand.nextInt(rand.nextInt(40) + 1) + 1);
        if (rand.nextInt(15) != 0) {
            cavesToGenerate = 0;
        }

        int yRange = this.maxY - this.minY;

        for (int i = 0; i < cavesToGenerate; ++i) {
            double blockX = chunkX * 16 + rand.nextInt(16);
            double blockY = this.minY + rand.nextInt(rand.nextInt(yRange - 8) + 8);
            double blockZ = chunkZ * 16 + rand.nextInt(16);
            int numBranches = 1;
            if (rand.nextInt(4) == 0) {
                this.generateHubRoom(rand.nextLong(), baseChunkX, baseChunkZ, result, blockX, blockY, blockZ);
                numBranches += rand.nextInt(4);
            }

            for (int l1 = 0; l1 < numBranches; ++l1) {
                float yRot = rand.nextFloat() * 3.1415927F * 2.0F;
                float xRot = (rand.nextFloat() - 0.5F) * 2.0F / 8.0F;
                float initialRadius = rand.nextFloat() * 2.0F + rand.nextFloat();
                this.generateCave(rand.nextLong(), baseChunkX, baseChunkZ, result, blockX, blockY, blockZ, initialRadius, yRot, xRot, 0, 0, 1.0);
            }
        }

    }
}
