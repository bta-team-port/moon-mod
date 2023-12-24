package teamport.moonmod.item;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemFood;
import teamport.moonmod.MoonMod;
import turniplabs.halplibe.helper.ItemHelper;

public class MoonModItems {

	public static final Item cheese = ItemHelper.createItem(MoonMod.MOD_ID,
		new ItemFood("cheese", 16600, 4, false),
		"cheese",
		"cheeseSlice.png");

	public static final Item sonicScrewdriver = ItemHelper.createItem(MoonMod.MOD_ID,
		new ItemScrewdriver("Sonic Screwdriver", 16601),
		"screwdriver",
		"screwer.png");
	public void initializeItems(){}
}
