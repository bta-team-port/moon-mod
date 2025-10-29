package teamport.moonmod.world;

import net.minecraft.core.Global;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.provider.BiomeProvider;
import net.minecraft.core.world.generate.chunk.ChunkGenerator;
import net.minecraft.core.world.type.WorldType;
import net.minecraft.core.world.weather.Weathers;
import teamport.moonmod.blocks.MoonBlocks;
import teamport.moonmod.world.chunk.BiomeProviderMoon;
import teamport.moonmod.world.chunk.ChunkGeneratorMoon;

public class WorldTypeMoon extends WorldType {
	public WorldTypeMoon(WorldType.Properties properties) {
		super(properties);
	}

	public static WorldType.Properties defaultProperties(String translationKey) {
		return Properties.of(translationKey)
			.defaultWeather(Weathers.OVERWORLD_CLEAR)
			.seasonConfig(null)
			.dayNightCycleTicks(Global.DAY_LENGTH_TICKS)
			.oceanBlock(null)
			.fillerBlock(MoonBlocks.REGOLITH);
	}

	@Override
	public int getMinY() {
		return 0;
	}

	@Override
	public int getMaxY() {
		return 127;
	}

	@Override
	public int getOceanY() {
		return 0;
	}

	@Override
	public BiomeProvider createBiomeProvider(World world) {
		return new BiomeProviderMoon(world.getRandomSeed(), this);
	}

	@Override
	public ChunkGenerator createChunkGenerator(World world) {
		return new ChunkGeneratorMoon(world);
	}

	@Override
	public boolean isValidSpawn(World world, int x, int y, int z) {
		return world.getBlockId(x, y -1, z) == MoonBlocks.REGOLITH.id();
	}

	@Override
	public boolean mayRespawn() {
		return false;
	}

	@Override
	public float getTimeOfDay(World world, long tick, float partialTick) {
		return 24000;
	}

	@Override
	public int getSkyDarken(World world, long tick, float partialTick) {
		int subtracted;
		float f1 = this.getCelestialAngle(world, tick, partialTick);
		float f2 = 1.0f - (MathHelper.cos(f1 * 3.141593f * 2.0f) * 2.0f + 0.5f);
		if (f2 < 0.0f) {
			f2 = 0.0f;
		}
		if (f2 > 1.0f) {
			f2 = 1.0f;
		}
		float weatherOffset = 0.0f;
		if (world.getCurrentWeather() != null) {
			weatherOffset = (float)world.getCurrentWeather().subtractLightLevel * world.weatherManager.getWeatherIntensity() * world.weatherManager.getWeatherPower();
		}
		if ((subtracted = (int)(f2 * (11.0f - weatherOffset) + weatherOffset)) > 8) {
			subtracted = 12;
		}
		return subtracted;
	}

	@Override
	public float getCelestialAngle(World world, long tick, float partialTick) {
		return 0.5F;
	}

//	@Override
//	public float getGravityScalar() {
//		return 0.22F;
//	}
//
//	@Override
//	public boolean suffocate() {
//		return true;
//	}
//
//	@Override
//	public String getCelestialMoonTexture() {
//		return "/terrain/earth.png";
//	}
//
//	@Override
//	public String getCelestialSunTexture() {
//		return "/terrain/sun.png";
//	}
//
//	@Override
//	public float getStarBrightness(World world) {
//		return 1.0F;
//	}
}

