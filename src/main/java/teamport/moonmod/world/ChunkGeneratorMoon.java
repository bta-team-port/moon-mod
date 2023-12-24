package teamport.moonmod.world;

import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.MapGenCaves;
import net.minecraft.core.world.generate.chunk.perlin.ChunkGeneratorPerlin;
import net.minecraft.core.world.generate.chunk.perlin.overworld.TerrainGeneratorOverworld;
import teamport.moonmod.compat.terrainapi.ChunkDecoratorMoonAPI;

public class ChunkGeneratorMoon extends ChunkGeneratorPerlin {

	protected ChunkGeneratorMoon(World world) {
		super(world, new ChunkDecoratorMoonAPI(world), new TerrainGeneratorOverworld(world), new SurfaceGeneratorMoon(world), new MapGenCaves(false));
	}
}
