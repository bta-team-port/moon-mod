package teamport.moonmod.world;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.worldtype.WorldTypeFX;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.util.phys.Vec3;
import net.minecraft.core.world.World;
import net.minecraft.core.world.type.WorldType;

@Environment(EnvType.CLIENT)
public class WorldTypeFXMoon extends WorldTypeFX {
    public Float cloudHeight = -100f;

    public WorldTypeFXMoon(WorldType worldType) {
        super(worldType);
    }

    public boolean hasGround() {
        return false;
    }

    public WorldTypeFX setCloudHeight(float cloudHeight) {
        this.cloudHeight = cloudHeight;
        return this;
    }

    @Override
    public boolean hasAurora() {
        return false;
    }

    public float getCloudHeight() {
        return this.cloudHeight == null ? (float) (this.worldType.getMaxY() - 1000) : this.cloudHeight;
    }

    @Override
    public float[] getSunriseColor(float timeOfDay, float partialTick) {
        return new float[]{0.0f, 0.0f, 0.0f, 0.0f};
    }

    @Override
    public Vec3 getFogColor(World world, double x, double y, double z, float celestialAngle, float partialTick) {
        float timeOfDay = MathHelper.clamp(MathHelper.cos(celestialAngle * 3.1415927F * 2.0F) * 2.0F + 0.5F, 0.0F, 1.0F);
        int i = 0;
        float f2 = MathHelper.cos(timeOfDay * 3.141593F * 2.0F) * 2.0F + 0.5F;
        if (f2 < 0.0F) {
            f2 = 0.0F;
        }
        if (f2 > 1.0F) {
            f2 = 1.0F;
        }
        float f3 = (float) (0) / 255F;
        float f4 = (float) (0) / 255F;
        float f5 = (float) (0) / 255F;
        f3 *= f2 * 0.94F + 0.06F;
        f4 *= f2 * 0.94F + 0.06F;
        f5 *= f2 * 0.91F + 0.09F;
        return Vec3.getPermanentVec3(f3, f4, f5);
    }
}
