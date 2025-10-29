package teamport.moonmod.world.chunk;

import net.minecraft.core.block.Blocks;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.chunk.perlin.DensityGenerator;
import net.minecraft.core.world.generate.chunk.perlin.TerrainGeneratorLerp;
import net.minecraft.core.world.generate.chunk.perlin.overworld.DensityGeneratorOverworld;
import net.minecraft.core.world.type.WorldType;

public class TerrainGeneratorMoon extends TerrainGeneratorLerp {
	private final DensityGenerator densityGenerator;

	protected TerrainGeneratorMoon(World world, DensityGenerator densityGenerator) {
		super(world);
		this.densityGenerator = densityGenerator;
	}

	public TerrainGeneratorMoon(World world) {
		this(world, new DensityGeneratorOverworld(world));
	}

	protected int getBlockAt(int x, int y, int z, double density) {
		WorldType type = this.world.getWorldType();
		if (y <= type.getMinY() + this.rand.nextInt(5)) {
			return Blocks.BEDROCK.id();
		} else if (density > 0.0) {
			return type.getFillerBlockId();
		} else {
			return y >= type.getMinY() && y < type.getMinY() + type.getOceanY() ? type.getOceanBlockId() : 0;
		}
	}

	public DensityGenerator getDensityGenerator() {
		return this.densityGenerator;
	}
}
