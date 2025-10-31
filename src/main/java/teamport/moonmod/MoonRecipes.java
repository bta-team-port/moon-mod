package teamport.moonmod;

import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.RecipeSymbol;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryDyeing;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryUndyeing;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.helper.DyeColor;
import teamport.moonmod.blocks.MoonBlocks;
import teamport.moonmod.items.MoonItems;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderShaped;
import turniplabs.halplibe.util.RecipeEntrypoint;

import java.util.ArrayList;
import java.util.List;

import static teamport.moonmod.MoonMod.MOD_ID;

public class MoonRecipes implements RecipeEntrypoint {
	@Override
	public void onRecipesReady() {

		RecipeBuilder.Trommel(MOD_ID)
			.setInput(MoonBlocks.REGOLITH)
			.addEntry(new WeightedRandomLootObject(Items.ORE_RAW_IRON.getDefaultStack(), 2, 4), 15.0)
			.addEntry(new WeightedRandomLootObject(Items.DUST_REDSTONE.getDefaultStack(), 2, 4), 20.0)
			.addEntry(new WeightedRandomLootObject(Items.AMMO_PEBBLE.getDefaultStack(), 1, 5), 25.0)
			.create("trommel_regolith");

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("GGG", "GRG", "GIG")
			.addInput('G', Blocks.GLASS)
			.addInput('R', Items.DUST_GLOWSTONE)
			.addInput('I', Items.INGOT_IRON)
			.create("lamp", new ItemStack(MoonBlocks.LAMP, 4));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("11", "11")
			.addInput('1', Items.BUCKET_MILK)
			.setConsumeContainer(false)
			.create("cheese_block_from_milk", MoonBlocks.CHEESE.getDefaultStack());

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("11", "11")
			.addInput('1', MoonItems.CHEESE)
			.create("cheese_block_from_cheese", MoonBlocks.CHEESE.getDefaultStack());

		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(MoonBlocks.CHEESE)
			.create("cheese_from_cheese_block", new ItemStack(MoonItems.CHEESE, 4));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("111", "121")
			.addInput('1', MoonBlocks.WOOL_REINFORCED)
			.addInput('2', Blocks.GLASS)
			.create("space_helmet", MoonItems.ARMOR_HELMET_MOON.getDefaultStack());

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("1 1", "212", "222")
			.addInput('1', Items.INGOT_IRON)
			.addInput('2', MoonBlocks.WOOL_REINFORCED)
			.create("space_suit", MoonItems.ARMOR_CHESTPLATE_MOON.getDefaultStack());

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("121", "1 1", "2 2")
			.addInput('1', MoonBlocks.WOOL_REINFORCED)
			.addInput('2', Items.INGOT_IRON)
			.create("space_leggings", MoonItems.ARMOR_LEGGINGS_MOON.getDefaultStack());

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("1 1", "2 2")
			.addInput('1', Items.INGOT_IRON)
			.addInput('2', MoonBlocks.WOOL_REINFORCED)
			.create("space_boots", MoonItems.ARMOR_BOOTS_MOON.getDefaultStack());

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("  1", " 2 ", "2  ")
			.addInput('1', Items.DUST_REDSTONE)
			.addInput('2', Items.INGOT_IRON)
			.create("sonic_screwdriver", MoonItems.SCREWDRIVER_SONIC.getDefaultStack());

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("121", "212", "121")
			.addInput('1', MoonBlocks.REGOLITH)
			.addInput('2', Items.SULPHUR)
			.create("tnt_regolith", new ItemStack(Blocks.TNT, 2));

		RecipeBuilderShaped clothShape = new RecipeBuilderShaped(MOD_ID, "111", "121", "111")
			.addInput('2', Items.INGOT_GOLD);


		clothShape
			.addInput('1', Blocks.WOOL, 0)
			.create("cloth_from_white_wool", new ItemStack(MoonBlocks.WOOL_REINFORCED, 8, 0));
		clothShape
			.addInput('1', Blocks.WOOL, 1)
			.create("cloth_from_yellow_wool", new ItemStack(MoonBlocks.WOOL_REINFORCED, 8, 1));
		clothShape
			.addInput('1', Blocks.WOOL, 2)
			.create("cloth_from_magenta_wool", new ItemStack(MoonBlocks.WOOL_REINFORCED, 8, 2));
		clothShape
			.addInput('1', Blocks.WOOL, 3)
			.create("cloth_from_lightblue_wool", new ItemStack(MoonBlocks.WOOL_REINFORCED, 8, 3));
		clothShape
			.addInput('1', Blocks.WOOL, 4)
			.create("cloth_from_yellow_wool", new ItemStack(MoonBlocks.WOOL_REINFORCED, 8, 4));
		clothShape
			.addInput('1', Blocks.WOOL, 5)
			.create("cloth_from_lime_wool", new ItemStack(MoonBlocks.WOOL_REINFORCED, 8, 5));
		clothShape
			.addInput('1', Blocks.WOOL, 6)
			.create("cloth_from_pink_wool", new ItemStack(MoonBlocks.WOOL_REINFORCED, 8, 6));
		clothShape
			.addInput('1', Blocks.WOOL, 7)
			.create("cloth_from_gray_wool", new ItemStack(MoonBlocks.WOOL_REINFORCED, 8, 7));
		clothShape
			.addInput('1', Blocks.WOOL, 8)
			.create("cloth_from_silver_wool", new ItemStack(MoonBlocks.WOOL_REINFORCED, 8, 8));
		clothShape
			.addInput('1', Blocks.WOOL, 9)
			.create("cloth_from_cyan_wool", new ItemStack(MoonBlocks.WOOL_REINFORCED, 8, 9));
		clothShape
			.addInput('1', Blocks.WOOL, 10)
			.create("cloth_from_purple_wool", new ItemStack(MoonBlocks.WOOL_REINFORCED, 8, 10));
		clothShape
			.addInput('1', Blocks.WOOL, 11)
			.create("cloth_from_blue_wool", new ItemStack(MoonBlocks.WOOL_REINFORCED, 8, 11));
		clothShape
			.addInput('1', Blocks.WOOL, 12)
			.create("cloth_from_brown_wool", new ItemStack(MoonBlocks.WOOL_REINFORCED, 8, 12));
		clothShape
			.addInput('1', Blocks.WOOL, 13)
			.create("cloth_from_green_wool", new ItemStack(MoonBlocks.WOOL_REINFORCED, 8, 13));
		clothShape
			.addInput('1', Blocks.WOOL, 14)
			.create("cloth_from_red_wool", new ItemStack(MoonBlocks.WOOL_REINFORCED, 8, 14));
		clothShape
			.addInput('1', Blocks.WOOL, 15)
			.create("cloth_from_black_wool", new ItemStack(MoonBlocks.WOOL_REINFORCED, 8, 15));

		Registries.RECIPES.addCustomRecipe(
			"moonmod:workbench/reinforced_wools_dyeing",
			new RecipeEntryDyeing(
				new RecipeSymbol("moonmod:reinforced_wools"),
				MoonBlocks.WOOL_REINFORCED.getDefaultStack(), false, false
			)
		);
		Registries.RECIPES.addCustomRecipe(
			"moonmod:workbench/reinforced_wools_undyeing",
			new RecipeEntryUndyeing(
				new RecipeSymbol("moonmod:reinforced_wools"),
				MoonBlocks.WOOL_REINFORCED.getDefaultStack()
			)
		);

	}

	@Override
	public void initNamespaces() {
		RecipeBuilder.initNameSpace(MOD_ID);
		RecipeBuilder.getRecipeNamespace(MOD_ID);

		List<ItemStack> woolStackList = new ArrayList<>();

		DyeColor[] var17 = DyeColor.values();

		for (DyeColor color : var17) {
			woolStackList.add(new ItemStack(MoonBlocks.WOOL_REINFORCED, 1, color.blockMeta));
		}

		Registries.ITEM_GROUPS.register("moonmod:reinforced_wools", woolStackList);
	}
}
