package teamport.moonmod.world;

import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.world.type.WorldType;
import net.minecraft.core.world.type.WorldTypes;
import teamport.moonmod.world.chunk.skyblock.WorldTypeMoonSkyblock;

public abstract class MoonWorldTypes {
	public static WorldType MOON_DEFAULT;
	public static WorldType MOON_SKYBLOCK;
	public static WorldType MOON_RETRO;

	public MoonWorldTypes() {
	}

	public static WorldType register(String key, WorldType worldType) {
		Registries.WORLD_TYPES.register(key, worldType);
		return worldType;
	}

	private static boolean hasInit = false;

	public static void init() {
		if (!hasInit) {
			hasInit = true;
			initializeWorldTypes();
		}

	}

	public static void initializeWorldTypes() {
		MOON_DEFAULT = WorldTypes.register("moon:moon.default", new WorldTypeMoon
			(WorldTypeMoon.defaultProperties("worldtype.moon.default")
				.bounds(0, 127, 0)
				.portalBounds(32, 96)));


		MOON_SKYBLOCK = WorldTypes.register("moon:moon.skyblock", new WorldTypeMoonSkyblock
			(WorldTypeMoon.defaultProperties("worldtype.moon.skyblock")
				.bounds(0, 127, 0)));


		MOON_RETRO = WorldTypes.register("moon:moon.retro", new WorldTypeMoon
			(WorldTypeMoon.defaultProperties("worldtype.moon.retro")
				.bounds(0, 127, 0)
				.portalBounds(32, 96)
				.setRetro()));
	}
}
