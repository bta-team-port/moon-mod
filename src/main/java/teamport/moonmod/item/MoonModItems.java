package teamport.moonmod.item;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemArmor;
import net.minecraft.core.item.ItemFood;
import net.minecraft.core.item.material.ArmorMaterial;
import teamport.moonmod.MoonMod;
import turniplabs.halplibe.helper.ArmorHelper;
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

	public static final ArmorMaterial spacesuit = ArmorHelper.createArmorMaterial("moonSuit", 240, 20.0f, 20.0f, 20.0f, 20.0f);

	public static final Item spaceHelmet = ItemHelper.createItem(MoonMod.MOD_ID,
		new ItemArmor("Space Helmet", 16602, spacesuit, 0),
		"armor.helmet.space",
		"spaceHelmet.png");

	public static final Item spaceSuit = ItemHelper.createItem(MoonMod.MOD_ID,
		new ItemArmor("Space Suit", 16603, spacesuit, 1),
		"armor.chestplate.space",
		"spaceSuit.png");

	public static final Item spacePants = ItemHelper.createItem(MoonMod.MOD_ID,
		new ItemArmor("Space Pants", 16604, spacesuit, 2),
		"armor.leggings.space",
		"spacePants.png");

	public static final Item spaceBoots = ItemHelper.createItem(MoonMod.MOD_ID,
		new ItemArmor("Space Boots", 16605, spacesuit, 3),
		"armor.boots.space",
		"spaceBoots.png");
	public void initializeItems(){}
}
