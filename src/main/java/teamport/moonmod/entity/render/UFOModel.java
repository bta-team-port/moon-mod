package teamport.moonmod.entity.render;

import net.minecraft.core.util.helper.MathHelper;
import useless.dragonfly.model.entity.BenchEntityModel;

public class UFOModel extends BenchEntityModel {

	@Override
	public void setRotationAngles(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
		super.setRotationAngles(limbSwing, limbYaw, limbPitch, headYaw, headPitch, scale);

		if (this.getIndexBones().containsKey("head")) {
			this.getIndexBones().get("head")
				.setRotationAngle(0.0F, 0.0F, 0.0F);

			this.getIndexBones().get("head")
				.rotateAngleX = headPitch / (float) (90.0 / Math.PI);

			this.getIndexBones().get("head")
				.rotateAngleY = headYaw / ((float) (180.0 / Math.PI));
		}

		if (this.getIndexBones().containsKey("body")) {
			this.getIndexBones().get("body")
				.setRotationAngle(0.0F, 0.0F, 0.0F);
		}

		if (this.getIndexBones().containsKey("leftArm")) {
			this.getIndexBones().get("leftArm")
				.setRotationAngle(0.0F, 0.0F, 0.0F);

			this.getIndexBones().get("leftArm")
				.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbYaw * 0.5F;

			this.getIndexBones().get("leftArm")
				.rotateAngleX -= MathHelper.sin(limbPitch * 0.067F) * 0.05F;
		}


		if (this.getIndexBones().containsKey("rightArm")) {
			this.getIndexBones().get("rightArm")
				.setRotationAngle(0.0F, 0.0F, 0.0F);

			this.getIndexBones().get("rightArm")
				.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.141593F) * 2.0F * limbYaw * 0.5F;

			this.getIndexBones().get("rightArm")
				.rotateAngleX += MathHelper.sin(limbPitch * 0.067F) * 0.05F;
		}

		if (this.getIndexBones().containsKey("leftLeg")) {
			this.getIndexBones().get("leftLeg")
				.setRotationAngle(0.0F, 0.0F, 0.0F);

			this.getIndexBones().get("leftLeg")
				.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbYaw;
		}

		if (this.getIndexBones().containsKey("rightLeg")) {
			this.getIndexBones().get("rightLeg")
				.setRotationAngle(0.0F, 0.0F, 0.0F);

			this.getIndexBones().get("rightLeg")
				.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbYaw;
		}
	}
}
