package teamport.moonmod.world;

import net.minecraft.core.world.World;

public interface ISpace {
	float getGravityScalar();
	boolean suffocate();
	String getCelestialMoonTexture();
	String getCelestialSunTexture();
	float getStarBrightness(World world);
}
