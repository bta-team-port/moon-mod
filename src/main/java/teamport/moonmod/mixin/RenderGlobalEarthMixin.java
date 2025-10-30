package teamport.moonmod.mixin;

import net.minecraft.client.render.RenderGlobal;
import net.minecraft.client.render.TextureManager;
import net.minecraft.client.render.texture.Texture;
import net.minecraft.client.world.WorldClient;
import net.minecraft.core.world.type.WorldType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import teamport.moonmod.world.ISpace;

@Mixin(value = RenderGlobal.class, remap = false)
public class RenderGlobalEarthMixin {

	@Shadow
	private WorldClient worldObj;

	@Redirect(
		method = "drawSky(F)V",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/client/render/TextureManager;loadTexture(Ljava/lang/String;)Lnet/minecraft/client/render/texture/Texture;"
		)
	)
	public Texture onLoadCelestialTexture(TextureManager instance, String path) {
		WorldType worldType = this.worldObj.getWorldType();
		if (worldType instanceof ISpace) {
			ISpace space = (ISpace) worldType;
			if ("/assets/minecraft/textures/terrain/moon.png".equals(path)) {
				String customMoonPath = space.getCelestialMoonTexture();
				if (customMoonPath != null && !customMoonPath.isEmpty()) {
					return instance.loadTexture(customMoonPath);
				}
			} else if ("/assets/minecraft/textures/terrain/sun.png".equals(path)) {
				String customSunPath = space.getCelestialSunTexture();
				if (customSunPath != null && !customSunPath.isEmpty()) {
					return instance.loadTexture(customSunPath);
				}
			}
		}
		return instance.loadTexture(path);
	}

}
