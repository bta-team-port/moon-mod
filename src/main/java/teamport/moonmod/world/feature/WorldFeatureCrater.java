package teamport.moonmod.world.feature;

import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class WorldFeatureCrater extends WorldFeature {

	public boolean isInsideEllipsoid(int x, int y, int z, float rx2, float ry2, float rz2, Random random){
		return ((x*x)/rx2 + (y*y)/ry2 + (z*z)/rz2) <= 1 + (random.nextFloat()/15 - random.nextFloat()/25);
	}

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {

		if (!world.isClientSide) {
			int sizeX = random.nextInt(16) + 10;
			int sizeZ = random.nextInt(16) + 10;
			int sizeY = random.nextInt(8) + 8;

			int rx2 = (sizeX) * (sizeX);
			int ry2 = (sizeY) * (sizeY);
			int rz2 = (sizeZ) * (sizeZ);

			for (int craterX = -sizeX; craterX < sizeX; craterX++) {
				for (int craterY = -sizeY; craterY < sizeY; craterY++) {
					for (int craterZ = -sizeZ; craterZ < sizeZ; craterZ++) {
						if (isInsideEllipsoid(craterX, craterY, craterZ, rx2, ry2, rz2, random)){
							world.setBlockWithNotify(x + craterX, y + craterY, z + craterZ, 0);
						}
					}
				}
			}
			return true;
		}
		return true;
	}
}
