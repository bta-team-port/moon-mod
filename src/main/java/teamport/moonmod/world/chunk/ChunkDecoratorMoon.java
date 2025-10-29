package teamport.moonmod.world.chunk;

import net.minecraft.core.block.*;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.chunk.Chunk;
import net.minecraft.core.world.generate.chunk.ChunkDecorator;
import net.minecraft.core.world.generate.feature.WorldFeatureOre;

import java.util.Random;

public class ChunkDecoratorMoon implements ChunkDecorator {
	private final World world;

	protected ChunkDecoratorMoon(World world) {
		this.world = world;
	}

	public void decorate(Chunk chunk) {
		this.world.scheduledUpdatesAreImmediate = true;
		int chunkX = chunk.xPosition;
		int chunkZ = chunk.zPosition;
		int minY = this.world.getWorldType().getMinY();
		int maxY = this.world.getWorldType().getMaxY();
		int rangeY = maxY + 1 - minY;
		float oreHeightModifier = (float)rangeY / 128.0F;
		BlockLogicSand.fallInstantly = true;
		int x = chunkX * 16;
		int z = chunkZ * 16;
		int y = this.world.getHeightValue(x + 16, z + 16);
		Biome biome = this.world.getBlockBiome(x + 16, y, z + 16);
		Random rand = new Random(this.world.getRandomSeed());
		long l1 = rand.nextLong() / 2L * 2L + 1L;
		long l2 = rand.nextLong() / 2L * 2L + 1L;
		rand.setSeed((long)chunkX * l1 + (long)chunkZ * l2 ^ this.world.getRandomSeed());
		int j4;
		int k7;
		int k4;
		int treeDensity;

		for(j4 = 0; (float)j4 < 20.0F * oreHeightModifier; ++j4) {
			k7 = x + rand.nextInt(16);
			k4 = minY + rand.nextInt(rangeY);
			treeDensity = z + rand.nextInt(16);
			(new WorldFeatureOre(BlockLogicOreCoal.variantMap, 16)).place(this.world, rand, k7, k4, treeDensity);
		}

		for(j4 = 0; (float)j4 < 20.0F * oreHeightModifier; ++j4) {
			k7 = x + rand.nextInt(16);
			k4 = minY + rand.nextInt(rangeY / 2);
			treeDensity = z + rand.nextInt(16);
			(new WorldFeatureOre(BlockLogicOreIron.variantMap, 8)).place(this.world, rand, k7, k4, treeDensity);
		}

		for(j4 = 0; (float)j4 < 2.0F * oreHeightModifier; ++j4) {
			k7 = x + rand.nextInt(16);
			k4 = minY + rand.nextInt(rangeY / 4);
			treeDensity = z + rand.nextInt(16);
			(new WorldFeatureOre(BlockLogicOreGold.variantMap, 8)).place(this.world, rand, k7, k4, treeDensity);
		}

		for(j4 = 0; (float)j4 < 8.0F * oreHeightModifier; ++j4) {
			k7 = x + rand.nextInt(16);
			k4 = minY + rand.nextInt(rangeY / 8);
			treeDensity = z + rand.nextInt(16);
			(new WorldFeatureOre(BlockLogicOreRedstone.variantMap, 7)).place(this.world, rand, k7, k4, treeDensity);
		}

		for(j4 = 0; (float)j4 < oreHeightModifier; ++j4) {
			k7 = x + rand.nextInt(16);
			k4 = minY + rand.nextInt(rangeY / 8);
			treeDensity = z + rand.nextInt(16);
			(new WorldFeatureOre(BlockLogicOreDiamond.variantMap, 7)).place(this.world, rand, k7, k4, treeDensity);
		}

		BlockLogicSand.fallInstantly = false;
		this.world.scheduledUpdatesAreImmediate = false;
	}
}
