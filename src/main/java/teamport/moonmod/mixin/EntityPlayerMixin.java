package teamport.moonmod.mixin;

import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import teamport.moonmod.world.ModDimensions;

@Mixin(value = EntityPlayer.class, remap = false)
public class EntityPlayerMixin extends EntityLiving {
	@Shadow
	public int dimension;
	@Unique
	private long timeOfLastDimensionShift = 0;

	public EntityPlayerMixin(World world) {
		super(world);
	}

	@Inject(method = "tick()V", at = @At("TAIL"))
	private void moonThreshold(CallbackInfo ci){
		int delayMillis = 8000;
		long currentTime = System.currentTimeMillis();
		if (this.y > this.world.getWorldType().getMaxY()+5 && !world.isDaytime() && (currentTime-timeOfLastDimensionShift > delayMillis)){
			int targetDim = ModDimensions.dimensionMoon.id;

			if (this.dimension == targetDim) {
				ModDimensions.dimensionShift(0);
			} else {
				ModDimensions.dimensionShift(targetDim);
				this.yd = 0;
			}
			timeOfLastDimensionShift = currentTime;
		}
	}

}
