package teamport.moonmod.compat.terrainapi;

import teamport.moonmod.world.feature.WorldFeatureCrater;
import useless.terrainapi.generation.overworld.OverworldRandomFeatures;
import useless.terrainapi.initialization.BaseInitialization;

public class MoonInitialization extends BaseInitialization {
	private static final TerrainMoonConfig config = ChunkDecoratorMoonAPI.config;
	public static final OverworldRandomFeatures randomFeatures = ChunkDecoratorMoonAPI.randomFeatures;

	@Override
	protected void initValues() {

	}

	@Override
	protected void initStructure() {

	}

	@Override
	protected void initOre() {

	}

	@Override
	protected void initRandom() {
		randomFeatures.addFeatureSurface(new WorldFeatureCrater(), 64);
	}

	@Override
	protected void initBiome() {

	}
}
