package teamport.moonmod.block;

import net.minecraft.client.render.block.color.BlockColorWater;
import net.minecraft.client.sound.block.BlockSound;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockPortal;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import turniplabs.halplibe.helper.BlockBuilder;

import static net.minecraft.core.block.Block.*;
import static teamport.moonmod.MoonMod.MOD_ID;

public class MoonModBlocks {
	private static int blockID = 2000;

	public static final Block regolith = new BlockBuilder(MOD_ID)
		.setBlockSound(new BlockSound("step.gravel", "step.gravel", 1.0f, 1.0f))
		.setHardness(0.5f)
		.setResistance(0.5f)
		.setTextures("regolith.png")
		.setTags(BlockTags.MINEABLE_BY_SHOVEL, BlockTags.CAVES_CUT_THROUGH)
		.build(new Block("regolith", blockID++, Material.dirt));

	public static final Block woolReinforced = new BlockBuilder(MOD_ID)
		.setBlockSound(new BlockSound("step.cloth", "step.cloth", 1.0f, 1.0f))
		.setHardness(1.1f)
		.setResistance(6.0f)
		.setTextures("clothBlock.png")
		.setTags(BlockTags.MINEABLE_BY_SHEARS, BlockTags.MINEABLE_BY_PICKAXE, BlockTags.CAVES_CUT_THROUGH)
		.build(new BlockReinforcedWool("wool.reinforced", blockID++, Material.cloth));

	public static final Block tent = new BlockBuilder(MOD_ID)
		.setBlockSound(new BlockSound("step.cloth", "step.cloth", 1.0f, 1.0f))
		.setHardness(1.1f)
		.setResistance(6.0f)
		.setTextures("tent.png")
		.setTags(BlockTags.MINEABLE_BY_SHEARS, BlockTags.MINEABLE_BY_PICKAXE, BlockTags.CAVES_CUT_THROUGH)
		.build(new Block("wool.reinforced", blockID++, Material.cloth));

	public static final Block cheese = new BlockBuilder(MOD_ID)
		.setBlockSound(new BlockSound("step.wood", "step.wood", 1.0f, 1.0f))
		.setHardness(0.6f)
		.setResistance(0.6f)
		.setTextures("cheeseBlock.png")
		.setTags(BlockTags.MINEABLE_BY_SHEARS, BlockTags.MINEABLE_BY_AXE)
		.build(new BlockCheese("cheese", blockID++, Material.cloth));

	public static final Block portalMoon = new BlockBuilder(MOD_ID)
		.setBlockSound(new BlockSound("step.stone", "random.glass", 1.0f, 1.0f))
		.setHardness(-1.0f)
		.setResistance(-1.0f)
		.setLuminance(15)
		.setTextures(13, 12)
		.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.NOT_IN_CREATIVE_MENU)
		.setBlockColor(new BlockColorWater())
		.build(new BlockPortal("portal.moon", blockID++, 3, MoonModBlocks.cheese.id, fire.id));

	public void initializeBlocks(){}
}
