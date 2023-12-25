package teamport.moonmod.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import teamport.moonmod.item.MoonModItems;

public class BlockCheese extends Block {
	public BlockCheese(String key, int id, Material material) {
		super(key, id, material);
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			case SILK_TOUCH:
			case PICK_BLOCK:
				return new ItemStack[]{new ItemStack(this)};
			default:
				return new ItemStack[]{new ItemStack(MoonModItems.cheese, 4)};
		}
	}

	@Override
	public boolean blockActivated(World var1, int var2, int var3, int var4,
								  EntityPlayer entityPlayer) {

		int slot = entityPlayer.inventory.currentItem;
		ItemStack is = entityPlayer.inventory.mainInventory[slot];
		if (is == null || is.itemID != MoonModItems.sonicScrewdriver.id)
			return false;

		is.damageItem(1, entityPlayer	);

		BlockPortalMoon portal = (BlockPortalMoon) MoonModBlocks.portalMoon;
		return portal.tryToCreatePortal(var1, var2, var3, var4);
	}

}
