package teamport.moonmod.blocks;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicPortal;
import net.minecraft.core.util.helper.DyeColor;
import net.minecraft.core.world.Dimension;

public class BlockLogicPortalMoon extends BlockLogicPortal {

	public BlockLogicPortalMoon(Block<?> block, Dimension targetDimension, Block<?> portalMaterial, Block<?> portalTrigger) {
		super(block, targetDimension, portalMaterial, portalTrigger);
	}

	public DyeColor fromMetadata(int meta) {
		return (meta & 8) == 0 ? DyeColor.SILVER : DyeColor.colorFromBlockMeta((meta & 240) >> 4);
	}
}
