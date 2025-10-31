package teamport.moonmod.items;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemArmor;
import net.minecraft.core.item.ItemFood;
import net.minecraft.core.item.ItemPlaceable;
import net.minecraft.core.item.material.ArmorMaterial;
import net.minecraft.core.util.helper.DamageType;
import teamport.moonmod.blocks.MoonBlocks;
import turniplabs.halplibe.helper.ArmorHelper;
import turniplabs.halplibe.helper.ItemBuilder;

import static teamport.moonmod.MoonConfig.itemID;
import static teamport.moonmod.MoonMod.MOD_ID;

public class MoonItems {

	public static Item CHEESE;

	public static Item SCREWDRIVER_SONIC;

	public static Item ARMOR_HELMET_MOON;
	public static Item ARMOR_CHESTPLATE_MOON;
	public static Item ARMOR_LEGGINGS_MOON;
	public static Item ARMOR_BOOTS_MOON;

	public static Item LANTERN_FIREFLY_WHITE;

	private static boolean hasInit = false;

	public static final ArmorMaterial MOON = ArmorHelper.createArmorMaterial(MOD_ID,
			"moon",
			240,
			20.0f,
			20.0f,
			20.0f,
			20.0f)
		.withProtectionPercentage(DamageType.DROWN, 100.0f);

	public static void init() {
		if (!hasInit) {
			hasInit = true;
			initializeItems();
		}
	}

	public static String itemKey(String string) {
		return MOD_ID + ":item/" + string;
	}

	public static void initializeItems() {
		CHEESE = new ItemBuilder(MOD_ID)
			.build(new ItemFood("cheese", itemKey("cheese"), itemID("CHEESE"), 3, 4, false, 4));


		SCREWDRIVER_SONIC = new ItemBuilder(MOD_ID)
			.build(new ItemScrewdriver("screwdriver.sonic", itemKey("screwdriver_sonic"), itemID("SCREWDRIVER_SONIC")).setMaxStackSize(1).setMaxDamage(63));


		ARMOR_HELMET_MOON = new ItemBuilder(MOD_ID)
			.build(new ItemArmor("armor.helmet.moon", itemKey("armor_helmet_moon"), itemID("ARMOR_HELMET_MOON"), MOON, 3));

		ARMOR_CHESTPLATE_MOON = new ItemBuilder(MOD_ID)
			.build(new ItemArmor("armor.chestplate.moon", itemKey("armor_chestplate_moon"), itemID("ARMOR_CHESTPLATE_MOON"), MOON, 2));

		ARMOR_LEGGINGS_MOON = new ItemBuilder(MOD_ID)
			.build(new ItemArmor("armor.leggings.moon", itemKey("armor_leggings_moon"), itemID("ARMOR_LEGGINGS_MOON"), MOON, 1));

		ARMOR_BOOTS_MOON = new ItemBuilder(MOD_ID)
			.build(new ItemArmor("armor.boots.moon", itemKey("armor_boots_moon"), itemID("ARMOR_BOOTS_MOON"), MOON, 0));


		LANTERN_FIREFLY_WHITE = new ItemBuilder(MOD_ID)
			.build(new ItemPlaceable("lantern.firefly.white", itemKey("lantern_firefly_white"), itemID("LANTERN_FIREFLY_WHITE"), MoonBlocks.LANTERN_FIREFLY_WHITE));
	}
}
