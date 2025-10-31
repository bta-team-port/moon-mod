package teamport.moonmod.blocks;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.DyeColor;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import teamport.moonmod.items.ItemScrewdriver;
import teamport.moonmod.items.MoonItems;

public class BlockLogicCheese extends BlockLogic {

	public BlockLogicCheese(Block<?> block, Material material) {
		super(block, material);
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			case SILK_TOUCH:
			case PICK_BLOCK:
				return new ItemStack[]{new ItemStack(this)};
			default:
				return new ItemStack[]{new ItemStack(MoonItems.CHEESE, 4)};
		}
	}

	@Override
	public boolean onBlockRightClicked(World world, int x, int y, int z, Player player, Side side, double xp, double yp) {
		if (player.getHeldItem() == null || !(player.getHeldItem().getItem() instanceof ItemScrewdriver))
			return false;
		else if (player.getHeldItem().getItem() instanceof ItemScrewdriver) {
			player.getHeldItem().damageItem(1, player);

			BlockLogicPortalMoon portal = MoonBlocks.PORTAL_MOON.getLogic();
			return portal.tryToCreatePortal(world, x, y, z, DyeColor.SILVER);
		} else return false;
	}
}
