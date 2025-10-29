package teamport.moonmod;

import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.*;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelStandard;
import teamport.moonmod.blocks.BlockModelWoolReinforced;
import teamport.moonmod.blocks.MoonBlocks;
import teamport.moonmod.items.MoonItems;
import turniplabs.halplibe.util.ModelEntrypoint;

import static net.minecraft.client.render.block.model.BlockModelStandard.BLOCK_TEXTURES;

public class MoonModels implements ModelEntrypoint {
	@Override
	public void initBlockModels(BlockModelDispatcher dispatcher) {

		dispatcher.addDispatch(new BlockModelPortal<>(MoonBlocks.PORTAL_MOON, "moonmod:block/portal_moon/")
			.setAllTextures(BLOCK_TEXTURES, "moonmod:block/portal_moon"));

		dispatcher.addDispatch(new BlockModelStandard<>(MoonBlocks.REGOLITH)
			.setAllTextures(BLOCK_TEXTURES, "moonmod:block/regolith"));

		dispatcher.addDispatch(new BlockModelStandard<>(MoonBlocks.CHEESE)
			.setAllTextures(BLOCK_TEXTURES, "moonmod:block/cheese"));

		dispatcher.addDispatch(new BlockModelWoolReinforced<>(MoonBlocks.WOOL_REINFORCED));

		dispatcher.addDispatch(new BlockModelStandard<>(MoonBlocks.LAMP)
			.setAllTextures(BLOCK_TEXTURES, "moonmod:block/lamp"));

		dispatcher.addDispatch(MoonBlocks.LANTERN_FIREFLY_WHITE, new BlockModelLantern<>(MoonBlocks.LANTERN_FIREFLY_WHITE)
			.setAllTextures(BLOCK_TEXTURES, "moonmod:block/lantern_firefly_white"));

	}

	@Override
	public void initItemModels(ItemModelDispatcher dispatcher) {
		dispatcher.addDispatch(new ItemModelStandard(MoonItems.CHEESE, null).setIcon("moonmod:item/cheese"));

		dispatcher.addDispatch(new ItemModelStandard(MoonItems.SCREWDRIVER_SONIC, null).setIcon("moonmod:item/screwdriver").setFull3D());

		dispatcher.addDispatch(new ItemModelStandard(MoonItems.ARMOR_HELMET_MOON, null).setIcon("moonmod:item/armor_helmet_moon"));
		dispatcher.addDispatch(new ItemModelStandard(MoonItems.ARMOR_CHESTPLATE_MOON, null).setIcon("moonmod:item/armor_chestplate_moon"));
		dispatcher.addDispatch(new ItemModelStandard(MoonItems.ARMOR_LEGGINGS_MOON, null).setIcon("moonmod:item/armor_leggings_moon"));
		dispatcher.addDispatch(new ItemModelStandard(MoonItems.ARMOR_BOOTS_MOON, null).setIcon("moonmod:item/armor_boots_moon"));

		dispatcher.addDispatch(new ItemModelStandard(MoonItems.LANTERN_FIREFLY_WHITE, null).setIcon("moonmod:item/lantern_firefly_white").setFullBright());
	}

	@Override
	public void initEntityModels(EntityRenderDispatcher dispatcher) {

	}

	@Override
	public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {

	}

	@Override
	public void initBlockColors(BlockColorDispatcher dispatcher) {

	}
}
