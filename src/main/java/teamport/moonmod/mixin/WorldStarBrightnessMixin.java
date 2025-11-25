package teamport.moonmod.mixin;

import net.minecraft.core.world.World;
import net.minecraft.core.world.type.WorldType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import teamport.moonmod.world.ISpace;

@Mixin(value = World.class, remap = false)
public class WorldStarBrightnessMixin {

    @Inject(method = "getStarBrightness(F)F", at = @At("HEAD"), cancellable = true)
    private void onGetStarBrightness(float partialTick, CallbackInfoReturnable<Float> cir) {
        World self = (World) (Object) this;
        WorldType worldType = self.getWorldType();
        if (worldType instanceof ISpace) {
            ISpace space = (ISpace) worldType;
            cir.setReturnValue(space.getStarBrightness(self));
            cir.cancel();
        }
    }
}
