package teamport.moonmod.mixin;

import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.world.World;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import teamport.moonmod.entity.MobUFO;
import teamport.moonmod.world.ISpace;

@Mixin(value = Mob.class, remap = false)
public abstract class MobGravityMixin extends Entity {

    @Unique
    private final Mob thisAs = (Mob) (Object) this;

    @Unique
    private double gravityScale;

    protected MobGravityMixin(World world) {
        super(world);
    }

    @Inject(method = "moveEntityWithHeading(FF)V", at = @At("HEAD"))
    private void getGravity(float moveStrafing, float moveForward, CallbackInfo cbi) {
        gravityScale = 1f;
        if (world.getWorldType() instanceof ISpace && !(thisAs instanceof MobUFO)) {
            gravityScale = ((ISpace) world.worldType).getGravityScalar();
        }
    }

    @Redirect(method = "moveEntityWithHeading(FF)V", at = @At(value = "FIELD", target = "Lnet/minecraft/core/entity/Mob;yd:D", opcode = Opcodes.PUTFIELD))
    private void setEntityGravity(Mob entity, double yd) {
        double offset = -(yd - this.yd);
        if ((0.021 > offset && offset > 0.019) || (0.081 > offset && offset > 0.079))
            entity.yd -= offset * gravityScale;
        else if ((-0.251 < yd && yd < -0.249)) entity.yd = yd * gravityScale;
        else entity.yd = yd;
    }


    @ModifyVariable(method = "causeFallDamage(F)V", at = @At(value = "STORE"), ordinal = 0)
    private int fallDamage(int i) {
        return (int) ((i * gravityScale) - (3 / gravityScale) + 3);
    }
}
