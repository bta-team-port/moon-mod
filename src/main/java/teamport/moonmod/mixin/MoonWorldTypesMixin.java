package teamport.moonmod.mixin;

import net.minecraft.core.world.Dimension;
import net.minecraft.core.world.type.WorldType;
import net.minecraft.core.world.type.WorldTypeGroups;
import net.minecraft.core.world.type.WorldTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import teamport.moonmod.world.MoonDimension;
import teamport.moonmod.world.MoonWorldTypes;

import java.util.HashMap;
import java.util.Map;

@Mixin(value = WorldTypeGroups.class, remap = false)
public class MoonWorldTypesMixin {

	@Unique
	private static final Map<WorldType, WorldType> overworldToMoonWorldTypeMap = new HashMap<>();

	static {
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
	}

	@Inject(method = "<clinit>", at = @At("TAIL"))
	private static void injectMoonSkyblock(CallbackInfo ci) {
		for (WorldTypeGroups.Group group : WorldTypeGroups.GROUPS) {

			WorldType overworldType = group.get(Dimension.OVERWORLD);
			group.with(MoonDimension.MOON, overworldToMoonWorldTypeMap.computeIfAbsent(overworldType, w -> MoonWorldTypes.MOON_DEFAULT));
		}
	}
}
