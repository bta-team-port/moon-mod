package teamport.moonmod.world.feature;

import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class WorldFeatureCrater extends WorldFeature {

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		System.out.println(x + " " + z);

		if (!world.isClientSide && y >= 60) {

			for (int sizeX = -4; sizeX <= 4; sizeX++) {
				for (int sizeY = -4; sizeY <= 4; sizeY++) {
					for (int sizeZ = -4; sizeZ <= 4; sizeZ++) {
						world.setBlockWithNotify(x + sizeZ, y + sizeY, z + sizeZ, 0);
					}
				}
			}

			return true;
		}
		return true;
	}
}
