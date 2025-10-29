package teamport.moonmod.world;

import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;

public class MoonBiomes {
	public static Biome LUNAR_PLAINS;

	public MoonBiomes() {
	}

	private static boolean hasInit = false;

	public static void init() {
		if (!hasInit) {
			hasInit = true;
			initializeBiomes();
		}
	}

	public static void initializeBiomes() {
		LUNAR_PLAINS = Biomes.register("moonmod:plains", (new BiomeMoon("moon.plains")));
	}
}
