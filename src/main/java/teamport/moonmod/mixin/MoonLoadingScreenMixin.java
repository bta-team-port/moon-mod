package teamport.moonmod.mixin;

import net.minecraft.client.render.LoadingScreenRenderer;
import net.minecraft.core.world.Dimension;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import teamport.moonmod.world.MoonDimension;

@Mixin(value = LoadingScreenRenderer.class, remap = false)
public abstract class MoonLoadingScreenMixin {

	@Shadow
	private String backgroundPath;

	@Inject(method = "updateLoadingBackground(Lnet/minecraft/core/world/Dimension;)V", at = @At("HEAD"), cancellable = true)
	public void customBackground(Dimension dimension, CallbackInfo ci) {
		if (dimension == MoonDimension.MOON) {
			this.backgroundPath = "/assets/moonmod/textures/gui/background-loading-moon.png";
			ci.cancel();
		}
	}
}
