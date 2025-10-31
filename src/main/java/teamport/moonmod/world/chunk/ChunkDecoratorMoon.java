package teamport.moonmod.world.chunk;

import net.minecraft.core.block.*;
import net.minecraft.core.world.World;
import net.minecraft.core.world.chunk.Chunk;
import net.minecraft.core.world.generate.chunk.ChunkDecorator;
import net.minecraft.core.world.generate.feature.WorldFeatureOre;
import teamport.moonmod.blocks.MoonBlocks;
import teamport.moonmod.world.feature.WorldFeatureCrater;

import java.util.Random;

public class ChunkDecoratorMoon implements ChunkDecorator {
	public final World world;

	public ChunkDecoratorMoon(World world) {
		this.world = world;
	}

	public void decorate(Chunk chunk) {
		this.world.scheduledUpdatesAreImmediate = true;
		int chunkX = chunk.xPosition;
		int chunkZ = chunk.zPosition;
		int minY = this.world.getWorldType().getMinY();
		int maxY = this.world.getWorldType().getMaxY();
		int rangeY = maxY + 1 - minY;
		float oreHeightModifier = (float) rangeY / 128.0F;
		BlockLogicSand.fallInstantly = true;
		int x = chunkX * 16;
		int z = chunkZ * 16;
		Random rand = new Random(this.world.getRandomSeed());
		long l1 = rand.nextLong() / 2L * 2L + 1L;
		long l2 = rand.nextLong() / 2L * 2L + 1L;
		rand.setSeed((long) chunkX * l1 + (long) chunkZ * l2 ^ this.world.getRandomSeed());
		int j4;
		int generateX;
		int generateY;
		int generateZ;


		if (rand.nextInt(12) == 1) {
			generateX = x + rand.nextInt(16);
			generateY = rangeY / 2;
			generateZ = z + rand.nextInt(16);
			(new WorldFeatureCrater()).place(this.world, rand, generateX, generateY, generateZ);
		}

		for (j4 = 0; (float) j4 < 7.5F * oreHeightModifier; ++j4) {
			generateX = x + rand.nextInt(16);
			generateY = minY + rand.nextInt(rangeY / 2);
			generateZ = z + rand.nextInt(16);
			(new WorldFeatureOre(MoonBlocks.CHEESE.id(), 8)).place(this.world, rand, generateX, generateY, generateZ);
		}

		for (j4 = 0; (float) j4 < 30.0F * oreHeightModifier; ++j4) {
			generateX = x + rand.nextInt(16);
			generateY = minY + rand.nextInt(rangeY);
			generateZ = z + rand.nextInt(16);
			(new WorldFeatureOre(BlockLogicOreCoal.variantMap, 16)).place(this.world, rand, generateX, generateY, generateZ);
		}

		for (j4 = 0; (float) j4 < 30.0F * oreHeightModifier; ++j4) {
			generateX = x + rand.nextInt(16);
			generateY = minY + rand.nextInt(rangeY / 2);
			generateZ = z + rand.nextInt(16);
			(new WorldFeatureOre(BlockLogicOreIron.variantMap, 8)).place(this.world, rand, generateX, generateY, generateZ);
		}

		for (j4 = 0; (float) j4 < 3.0F * oreHeightModifier; ++j4) {
			generateX = x + rand.nextInt(16);
			generateY = minY + rand.nextInt(rangeY / 4);
			generateZ = z + rand.nextInt(16);
			(new WorldFeatureOre(BlockLogicOreGold.variantMap, 8)).place(this.world, rand, generateX, generateY, generateZ);
		}

		for (j4 = 0; (float) j4 < 12.0F * oreHeightModifier; ++j4) {
			generateX = x + rand.nextInt(16);
			generateY = minY + rand.nextInt(rangeY / 8);
			generateZ = z + rand.nextInt(16);
			(new WorldFeatureOre(BlockLogicOreRedstone.variantMap, 7)).place(this.world, rand, generateX, generateY, generateZ);
		}

		for (j4 = 0; (float) j4 < 1.5f * oreHeightModifier; ++j4) {
			generateX = x + rand.nextInt(16);
			generateY = minY + rand.nextInt(rangeY / 8);
			generateZ = z + rand.nextInt(16);
			(new WorldFeatureOre(BlockLogicOreDiamond.variantMap, 7)).place(this.world, rand, generateX, generateY, generateZ);
		}

		BlockLogicSand.fallInstantly = false;
		this.world.scheduledUpdatesAreImmediate = false;
	}
}
