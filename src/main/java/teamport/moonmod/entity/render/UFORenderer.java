package teamport.moonmod.entity.render;

import net.minecraft.client.render.entity.LivingRenderer;
import net.minecraft.client.render.model.ModelBase;
import teamport.moonmod.entity.EntityUFO;

public class UFORenderer extends LivingRenderer<EntityUFO> {

	public UFORenderer(ModelBase model) {
		super(model, 0.25F);

		setRenderPassModel(model);
	}
}
