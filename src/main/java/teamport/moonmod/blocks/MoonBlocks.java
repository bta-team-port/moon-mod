package teamport.moonmod.blocks;

import net.minecraft.core.block.*;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.block.ItemBlockPainted;
import net.minecraft.core.sound.BlockSounds;
import teamport.moonmod.MoonMod;
import teamport.moonmod.items.MoonItems;
import teamport.moonmod.world.MoonDimension;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.util.BlockInitEntrypoint;

import static teamport.moonmod.MoonConfig.blockID;
import static teamport.moonmod.MoonMod.MOD_ID;

public class MoonBlocks implements BlockInitEntrypoint {

	public static Block<BlockLogicPortalMoon> PORTAL_MOON;

	public static Block<?> REGOLITH;

	public static Block<?> CHEESE;

	public static Block<?> WOOL_REINFORCED;

	public static Block<?> LAMP;

	public static Block<?> LANTERN_FIREFLY_WHITE;

	private static boolean hasInit = false;

	public static void init() {
		if (!hasInit) {
			hasInit = true;
			initializeBlocks();
		}
	}

	public static void initializeBlocks() {

		PORTAL_MOON = new BlockBuilder(MOD_ID)
			.setBlockSound(BlockSounds.GLASS)
			.setHardness(-1.0f)
			.setResistance(-1.0f)
			.setLuminance(15)
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.NOT_IN_CREATIVE_MENU)
			.build("portal.moon", "portal_aether", blockID("PORTAL_AETHER"), b -> new BlockLogicPortalMoon(b, MoonDimension.MOON, MoonBlocks.CHEESE, Blocks.FIRE));

		REGOLITH = new BlockBuilder(MOD_ID)
			.setBlockSound(BlockSounds.GRAVEL)
			.setHardness(0.5f)
			.setResistance(0.5f)
			.setTags(BlockTags.MINEABLE_BY_SHOVEL, BlockTags.CAVES_CUT_THROUGH, BlockTags.CAVE_GEN_REPLACES_SURFACE)
			.build("regolith", "regolith", blockID("REGOLITH"), b -> new BlockLogic(b, Material.dirt));

		CHEESE = new BlockBuilder(MOD_ID)
			.setBlockSound(BlockSounds.WOOD)
			.setHardness(0.6f)
			.setResistance(0.6f)
			.setTags(BlockTags.MINEABLE_BY_SHEARS, BlockTags.MINEABLE_BY_AXE)
			.build("cheese", "cheese", blockID("CHEESE"), b -> new BlockLogicCheese(b, Material.cloth));

		WOOL_REINFORCED = new BlockBuilder(MOD_ID)
			.setBlockSound(BlockSounds.CLOTH)
			.setHardness(1.1f)
			.setResistance(6.0f)
			.setBlockItem(b -> new ItemBlockPainted<>(b, false))
			.setTags(BlockTags.MINEABLE_BY_SHEARS, BlockTags.MINEABLE_BY_PICKAXE, BlockTags.CAVES_CUT_THROUGH)
			.build("wool.reinforced", "wool_reinforced", blockID("WOOL_REINFORCED"), BlockLogicWool::new);

		LAMP = new BlockBuilder(MOD_ID)
			.setBlockSound(BlockSounds.GLASS)
			.setHardness(0.6f)
			.setResistance(6.0f)
			.setLuminance(15)
			.setTags(BlockTags.MINEABLE_BY_PICKAXE)
			.build("lamp", "lamp", blockID("LAMP"), b -> new BlockLogic(b, Material.glass));

		LANTERN_FIREFLY_WHITE = new BlockBuilder(MOD_ID)
			.setBlockSound(BlockSounds.GLASS)
			.setHardness(0.1f)
			.setResistance(0.1f)
			.setUseInternalLight()
			.setLuminance(14)
			.setVisualUpdateOnMetadata()
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.NOT_IN_CREATIVE_MENU, BlockTags.MINEABLE_BY_PICKAXE)
			.build("lantern.firefly.white", "lantern_firefly_silver", blockID("LANTERN_FIREFLY_WHITE"), b -> new BlockLogicLanternFirefly(b, MoonMod.WHITE, () -> MoonItems.LANTERN_FIREFLY_WHITE))
			.setStatParent(() -> MoonItems.LANTERN_FIREFLY_WHITE);
	}

	@Override
	public void afterBlockInit() {
		init();
		MoonDimension.init();
		PORTAL_MOON.getLogic().targetDimension = MoonDimension.MOON;

	}
}
