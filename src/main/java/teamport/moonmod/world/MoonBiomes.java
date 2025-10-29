package teamport.moonmod.world;

import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.world.biome.Biome;

public class MoonBiomes {
	public static Biome LUNAR_PLAINS;

	public MoonBiomes() {
	}

	public static Biome register(String key, Biome biome) {
		Registries.BIOMES.register(key, biome);
		return biome;
	}

	private static boolean hasInit = false;

	public static void init() {
		if (!hasInit) {
			hasInit = true;
			initializeBiomes();
		}
	}

	public static void initializeBiomes() {
		LUNAR_PLAINS = register("moonmod:plains", (new BiomeMoon("lunar.plains")));
	}
}
