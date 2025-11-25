package teamport.moonmod.world;

import net.minecraft.core.world.type.WorldType;
import net.minecraft.core.world.type.WorldTypes;
import teamport.moonmod.world.chunk.skyblock.WorldTypeMoonSkyblock;

public abstract class MoonWorldTypes {
    public static WorldType MOON_DEFAULT;
    public static WorldType MOON_SKYBLOCK;
    public static WorldType MOON_RETRO;
    private static boolean hasInit = false;

    public MoonWorldTypes() {
    }

    public static void init() {
        if (!hasInit) {
            hasInit = true;
            initializeWorldTypes();
        }

    }

    public static void initializeWorldTypes() {
        MOON_DEFAULT = WorldTypes.register("moonmod:moon.default", new WorldTypeMoon
            (WorldTypeMoon.defaultProperties("worldtype.moon.default")
                .bounds(0, 255, 0)));


        MOON_SKYBLOCK = WorldTypes.register("moonmod:moon.skyblock", new WorldTypeMoonSkyblock
            (WorldTypeMoon.defaultProperties("worldtype.moon.skyblock")
                .bounds(0, 127, 0)));


        MOON_RETRO = WorldTypes.register("moonmod:moon.retro", new WorldTypeMoon
            (WorldTypeMoon.defaultProperties("worldtype.moon.retro")
                .bounds(0, 127, 0)
                .setRetro()));
    }
}
