package teamport.moonmod.item;

import net.minecraft.core.block.Block;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.sound.SoundType;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import teamport.moonmod.block.MoonModBlocks;

public class ItemScrewdriver extends Item {

	public ItemScrewdriver(String name, int id) {
		super(name, id);
		this.maxStackSize = 1;
		this.setMaxDamage(128);
	}

	public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
		blockX += side.getOffsetX();
		blockY += side.getOffsetY();
		blockZ += side.getOffsetZ();
		int i1 = world.getBlockId(blockX, blockY, blockZ);
		if (i1 == MoonModBlocks.cheese.id) {
			if (world.setBlockWithNotify(blockX, blockY, blockZ, MoonModBlocks.portalMoon.id)) {
				itemstack.damageItem(1, entityplayer);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
