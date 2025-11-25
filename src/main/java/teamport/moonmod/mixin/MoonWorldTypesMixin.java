package teamport.moonmod.mixin;

import net.minecraft.core.world.Dimension;
import net.minecraft.core.world.type.WorldType;
import net.minecraft.core.world.type.WorldTypeGroups;
import net.minecraft.core.world.type.WorldTypes;
import org.spongepowered.asm.mixin.Mixin;
import teamport.moonmod.world.MoonDimension;
import teamport.moonmod.world.MoonWorldTypes;

import java.util.HashMap;
import java.util.Map;

@Mixin(value = WorldTypeGroups.class, remap = false)
public abstract class MoonWorldTypesMixin {
    static {
        Map<WorldType, WorldType> overworldToMoonWorldTypeMap = new HashMap<>();
        for (WorldType t : new WorldType[]{
            WorldTypes.OVERWORLD_EXTENDED,
            WorldTypes.OVERWORLD_DEFAULT,
            WorldTypes.OVERWORLD_AMPLIFIED,
            WorldTypes.OVERWORLD_INLAND,
            WorldTypes.OVERWORLD_PARADISE,
            WorldTypes.OVERWORLD_WOODS,
            WorldTypes.OVERWORLD_HELL,
            WorldTypes.OVERWORLD_WINTER,
            WorldTypes.OVERWORLD_ISLANDS,
            WorldTypes.OVERWORLD_FLOATING,
            WorldTypes.FLAT,
            WorldTypes.EMPTY,
            WorldTypes.DEBUG,
        })
            overworldToMoonWorldTypeMap.put(t, MoonWorldTypes.MOON_DEFAULT);

        overworldToMoonWorldTypeMap.put(WorldTypes.OVERWORLD_SKYBLOCK, MoonWorldTypes.MOON_SKYBLOCK);

        overworldToMoonWorldTypeMap.put(WorldTypes.OVERWORLD_RETRO, MoonWorldTypes.MOON_RETRO);
        overworldToMoonWorldTypeMap.put(WorldTypes.OVERWORLD_CLASSIC, MoonWorldTypes.MOON_RETRO);
        overworldToMoonWorldTypeMap.put(WorldTypes.OVERWORLD_INDEV, MoonWorldTypes.MOON_RETRO);

        for (WorldTypeGroups.Group group : WorldTypeGroups.GROUPS) {

            WorldType overworldType = group.get(Dimension.OVERWORLD);
            group.with(MoonDimension.getMoon(), overworldToMoonWorldTypeMap.computeIfAbsent(overworldType, w -> MoonWorldTypes.MOON_DEFAULT));
        }
    }
}
