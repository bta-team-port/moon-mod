package teamport.moonmod.world.biome;

import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;

public class MoonBiomes {
	public static Biome BIOME_MOON = new BiomeMoon();

	public void initializeBiomes() {
		Biomes.register("moonmod.biome.moon", BIOME_MOON);
	}
}
