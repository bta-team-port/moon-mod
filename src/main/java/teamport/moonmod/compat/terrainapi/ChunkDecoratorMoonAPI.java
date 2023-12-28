package teamport.moonmod.compat.terrainapi;

import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.chunk.Chunk;
import net.minecraft.core.world.generate.feature.WorldFeature;
import useless.terrainapi.config.ConfigManager;
import useless.terrainapi.generation.ChunkDecoratorAPI;
import useless.terrainapi.generation.Parameters;
import useless.terrainapi.generation.overworld.OverworldRandomFeatures;

import java.util.Random;
import java.util.function.Function;

public class ChunkDecoratorMoonAPI extends ChunkDecoratorAPI {
	public static TerrainMoonConfig config = ConfigManager.getConfig("moon", TerrainMoonConfig.class);
	public static OverworldRandomFeatures randomFeatures = new OverworldRandomFeatures();

	public ChunkDecoratorMoonAPI(World world) {
		super(world);
	}

	@Override
	public void decorateAPI() {
		int xCoord = parameterBase.chunk.xPosition * 16;
		int zCoord = parameterBase.chunk.zPosition * 16;
		generateStructures(parameterBase.biome, parameterBase.chunk, parameterBase.random);
		generateOreFeatures(parameterBase.biome, xCoord, zCoord, parameterBase.random, parameterBase.chunk);
		generateBiomeFeature(parameterBase.biome,xCoord, zCoord, parameterBase.random, parameterBase.chunk);
		generateRandomFeatures(parameterBase.biome,xCoord, zCoord, parameterBase.random, parameterBase.chunk);
	}

	@Override
	public void generateStructures(Biome biome, Chunk chunk, Random random) {

	}

	@Override
	public void generateOreFeatures(Biome biome, int i, int i1, Random random, Chunk chunk) {

	}

	@Override
	public void generateRandomFeatures(Biome biome, int x, int z, Random random, Chunk chunk){
		int featureSize = randomFeatures.featureFunctionsList.size();
		for (int i = 0; i < featureSize; i++) {
			if (random.nextInt(randomFeatures.inverseProbabilityList.get(i)) != 0) {continue;}
			Function<Parameters, WorldFeature> featureFunction = randomFeatures.featureFunctionsList.get(i);

			int density = randomFeatures.densityFunctionsList.get(i)
				.apply(new Parameters(parameterBase, randomFeatures.densityParametersList.get(i)));

			float startingRange = randomFeatures.startingRangeList.get(i);
			float endingRange = randomFeatures.endingRangeList.get(i);
			if (-1.01 <= startingRange && startingRange <= -0.99 || -1.01 <= endingRange && endingRange <= -0.99){
				generateWithChancesSurface(featureFunction,
					new Parameters(parameterBase, randomFeatures.featureParametersList.get(i)),
					density, x, z, 8, 8, random);
			} else {
				generateWithChancesUnderground(featureFunction,
					new Parameters(parameterBase, randomFeatures.featureParametersList.get(i)),
					density, (int) (startingRange * rangeY), (int) (endingRange * rangeY), x, z, 8, 8, random);
			}
		}
	}

	@Override
	public void generateBiomeFeature(Biome biome, int i, int i1, Random random, Chunk chunk) {

	}
}
