package teamport.moonmod.mixin;

import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.LoadingScreenRenderer;
import net.minecraft.core.world.Dimension;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import teamport.moonmod.world.MoonDimension;

@Environment(EnvType.CLIENT)
@Mixin(value = LoadingScreenRenderer.class, remap = false)
public abstract class MoonLoadingScreenMixin {
    @Expression("'/assets/minecraft/textures/gui/background.png'")
    @ModifyExpressionValue(method = "updateLoadingBackground(Lnet/minecraft/core/world/Dimension;)V", at = @At("MIXINEXTRAS:EXPRESSION"))
    private String customBackground(String original, Dimension dimension) {
        if (dimension == MoonDimension.getMoon()) return "/assets/moonmod/textures/gui/background-loading-moon.png";
        return original;
    }
}
