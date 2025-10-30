package teamport.moonmod.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.model.Cube;
import net.minecraft.client.render.model.ModelBase;
import net.minecraft.core.util.helper.MathHelper;

@Environment(EnvType.CLIENT)
public class ModelUFO extends ModelBase {
	public Cube head;
	public Cube body;
	public Cube rightArm;
	public Cube leftArm;
	public Cube rightLeg;
	public Cube leftLeg;

	public ModelUFO() {
		this.head = new Cube(0, 0);
		this.head.addBox(-4.5F, -4.5F, -4.5F, 9, 9, 9, 0.0F);
		this.head.setRotationPoint(0.0F, 8.5F, 0.0F);

		this.body = new Cube(36, 0);
		this.body.addBox(-2.0F, -3.0F, -2.0F, 4, 6, 4, 0.0F);
		this.body.setRotationPoint(0.0F, 16.0F, 0.0F);

		this.leftArm = new Cube(0, 18);
		this.leftArm.addBox(-1.0F, -1.0F, -1.0F, 2, 7, 2, 0.0F);
		this.leftArm.setRotationPoint(3.0F, 14.5F, 0.0F);

		this.rightArm = new Cube(0, 18);
		this.rightArm.addBox(-1.0F, -1.0F, -1.0F, 2, 7, 2, 0.0F);
		this.rightArm.setRotationPoint(-3.0F, 14.5F, 0.0F);

		this.rightLeg = new Cube(8, 20);
		this.rightLeg.addBox(-1.0F, -1.0F, -1.0F, 2, 5, 2, 0.0F);
		this.rightLeg.setRotationPoint(-1.0F, 20.0F, 0.0F);

		this.leftLeg = new Cube(8, 20);
		this.leftLeg.addBox(-1.0F, -1.0F, -1.0F, 2, 5, 2, 0.0F);
		this.leftLeg.setRotationPoint(1.0F, 20.0F, 0.0F);
	}

	public void render(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
		this.setupAnimation(limbSwing, limbYaw, limbPitch, headYaw, headPitch, scale);
		this.head.render(scale);
		this.body.render(scale);
		this.rightArm.render(scale);
		this.leftArm.render(scale);
		this.rightLeg.render(scale);
		this.leftLeg.render(scale);
	}

	public void setupAnimation(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
		this.head.yRot = headYaw / 57.29578F;
		this.head.xRot = headPitch / 57.29578F;

		this.rightArm.xRot = MathHelper.cos(limbSwing * 0.6662F + 3.141593F) * 2.0F * limbYaw * 0.5F;
		this.leftArm.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbYaw * 0.5F;
		this.rightArm.zRot = 0.0F;
		this.leftArm.zRot = 0.0F;

		this.rightLeg.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbYaw;
		this.leftLeg.xRot = MathHelper.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbYaw;
		this.rightLeg.yRot = 0.0F;
		this.leftLeg.yRot = 0.0F;
		this.rightArm.yRot = 0.0F;
		this.leftArm.yRot = 0.0F;

		if (this.onGround > -9990.0F) {
			float f6 = this.onGround;
			this.body.yRot = MathHelper.sin(MathHelper.sqrt_float(f6) * 3.141593F * 2.0F) * 0.2F;
			this.rightArm.yRot += this.body.yRot;
			this.leftArm.yRot += this.body.yRot;
			this.leftArm.xRot += this.body.yRot;
			f6 = 1.0F - this.onGround;
			f6 *= f6;
			f6 *= f6;
			f6 = 1.0F - f6;
			float f7 = MathHelper.sin(f6 * 3.141593F);
			float f8 = MathHelper.sin(this.onGround * 3.141593F) * -(this.head.xRot - 0.7F) * 0.75F;
			this.rightArm.xRot -= (float) ((double) f7 * 1.2 + (double) f8);
			this.rightArm.yRot += this.body.yRot * 2.0F;
			this.rightArm.zRot = MathHelper.sin(this.onGround * 3.141593F) * -0.4F;
		}

		this.body.xRot = 0.0F;
		this.rightArm.zRot += MathHelper.cos(limbPitch * 0.09F) * 0.05F + 0.05F;
		this.leftArm.zRot -= MathHelper.cos(limbPitch * 0.09F) * 0.05F + 0.05F;
		this.rightArm.xRot += MathHelper.sin(limbPitch * 0.067F) * 0.05F;
		this.leftArm.xRot -= MathHelper.sin(limbPitch * 0.067F) * 0.05F;
	}
}
