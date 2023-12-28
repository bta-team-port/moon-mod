package teamport.moonmod.entity;

import net.minecraft.core.entity.animal.EntityAnimal;
import net.minecraft.core.world.World;

public class EntityUFO extends EntityAnimal {

	public EntityUFO(World world) {
		super(world);
		skinName = "ufo";
	}

	@Override
	public String getLivingSound() {
		return null;
	}

	@Override
	protected String getHurtSound() {
		return null;
	}

	@Override
	protected String getDeathSound() {
		return null;
	}
}
