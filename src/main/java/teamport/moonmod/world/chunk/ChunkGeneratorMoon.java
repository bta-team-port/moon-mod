package teamport.moonmod.world.chunk;

import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.LargeFeature;
import net.minecraft.core.world.generate.chunk.perlin.ChunkGeneratorPerlin;

public class ChunkGeneratorMoon extends ChunkGeneratorPerlin {
	public ChunkGeneratorMoon(World world) {
		super(world, new ChunkDecoratorMoon(world), new TerrainGeneratorMoon(world), new SurfaceGeneratorMoon(world), new LargeFeature[]{new CavesLargeFeatureMoon()});
	}
}
