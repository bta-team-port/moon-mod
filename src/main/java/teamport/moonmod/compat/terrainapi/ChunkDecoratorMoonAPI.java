package teamport.moonmod.compat.terrainapi;

import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.chunk.Chunk;
import useless.terrainapi.config.ConfigManager;
import useless.terrainapi.generation.ChunkDecoratorAPI;

import java.util.Random;

public class ChunkDecoratorMoonAPI extends ChunkDecoratorAPI {
	public static TerrainMoonConfig config = ConfigManager.getConfig("tropics", TerrainMoonConfig.class);

	public ChunkDecoratorMoonAPI(World world) {
		super(world);
	}

	@Override
	public void decorateAPI() {

	}

	@Override
	public void generateStructures(Biome biome, Chunk chunk, Random random) {

	}

	@Override
	public void generateOreFeatures(Biome biome, int i, int i1, Random random, Chunk chunk) {

	}

	@Override
	public void generateRandomFeatures(Biome biome, int i, int i1, Random random, Chunk chunk) {

	}

	@Override
	public void generateBiomeFeature(Biome biome, int i, int i1, Random random, Chunk chunk) {

	}
}
