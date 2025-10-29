package teamport.moonmod.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.MobRenderer;
import net.minecraft.client.render.model.ModelBase;

@Environment(EnvType.CLIENT)
public class MobRendererUFO extends MobRenderer<MobUFO> {
	public MobRendererUFO(ModelBase modelbase, float f) {
		super(modelbase, f);
	}
}
