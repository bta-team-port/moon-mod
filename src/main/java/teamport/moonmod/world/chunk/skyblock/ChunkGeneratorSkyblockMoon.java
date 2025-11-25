package teamport.moonmod.world.chunk.skyblock;

import net.minecraft.core.world.World;
import net.minecraft.core.world.chunk.Chunk;
import net.minecraft.core.world.generate.chunk.ChunkGenerator;
import net.minecraft.core.world.generate.chunk.ChunkGeneratorResult;
import teamport.moonmod.blocks.MoonBlocks;

public class ChunkGeneratorSkyblockMoon extends ChunkGenerator {
    public ChunkGeneratorSkyblockMoon(World world) {
        super(world, new ChunkDecoratorSkyblockMoon());
    }

    public ChunkGeneratorResult doBlockGeneration(Chunk chunk) {
        ChunkGeneratorResult result = new ChunkGeneratorResult();

        int x;
        int z;
        for (x = -3; x <= 1; ++x) {
            for (z = -2; z <= 3; ++z) {
                this.tryPlace(chunk, result, x, 64, z, MoonBlocks.REGOLITH.id());
                this.tryPlace(chunk, result, x, 65, z, MoonBlocks.REGOLITH.id());
                this.tryPlace(chunk, result, x, 66, z, MoonBlocks.REGOLITH.id());
            }
        }

        for (z = -1; z <= 2; ++z) {
            if (z != -1 && z != 2) {
                this.tryPlace(chunk, result, 2, 66, z, MoonBlocks.CHEESE.id());
                this.tryPlace(chunk, result, 2, 67, z, MoonBlocks.PORTAL_MOON.id());
                this.tryPlace(chunk, result, 2, 68, z, MoonBlocks.PORTAL_MOON.id());
                this.tryPlace(chunk, result, 2, 69, z, MoonBlocks.PORTAL_MOON.id());
                this.tryPlace(chunk, result, 2, 70, z, MoonBlocks.CHEESE.id());
            } else {
                this.tryPlace(chunk, result, 2, 66, z, MoonBlocks.CHEESE.id());
                this.tryPlace(chunk, result, 2, 67, z, MoonBlocks.CHEESE.id());
                this.tryPlace(chunk, result, 2, 68, z, MoonBlocks.CHEESE.id());
                this.tryPlace(chunk, result, 2, 69, z, MoonBlocks.CHEESE.id());
                this.tryPlace(chunk, result, 2, 70, z, MoonBlocks.CHEESE.id());
            }
        }

        return result;
    }

    public boolean contains(Chunk chunk, int xBlock, int zBlock) {
        return chunk.xPosition == xBlock >> 4 && chunk.zPosition == zBlock >> 4;
    }

    public void tryPlace(Chunk chunk, ChunkGeneratorResult result, int xBlock, int yBlock, int zBlock, int blockId) {
        if (this.contains(chunk, xBlock, zBlock)) {
            result.setBlock(xBlock & 15, yBlock, zBlock & 15, blockId);
        }
    }
}
