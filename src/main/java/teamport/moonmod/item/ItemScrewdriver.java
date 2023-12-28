package teamport.moonmod.item;

import net.minecraft.core.item.Item;

public class ItemScrewdriver extends Item {

	public ItemScrewdriver(String name, int id) {
		super(name, id);
		this.maxStackSize = 1;
		this.setMaxDamage(128);
	}
}
