package teamport.moonmod.world.chunk;

import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.chunk.perlin.overworld.SurfaceGeneratorOverworld;
import net.minecraft.core.world.noise.BasePerlinNoise;

public class SurfaceGeneratorMoon extends SurfaceGeneratorOverworld {
	protected SurfaceGeneratorMoon(World world, BasePerlinNoise<?> beachNoise, BasePerlinNoise<?> soilNoise, BasePerlinNoise<?> mainNoise, boolean generateStoneVariants) {
		super(world, beachNoise, soilNoise, mainNoise, generateStoneVariants);
	}

	public SurfaceGeneratorMoon(World world) {
		super(world);
	}
}
