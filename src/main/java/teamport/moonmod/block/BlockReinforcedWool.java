package teamport.moonmod.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class BlockReinforcedWool extends Block {
	public BlockReinforcedWool(String key, int id, Material material) {
		super(key, id, Material.cloth);
	}

	@Override
	public void onBlockAdded(World world, int i, int j, int k) {
		world.setBlockMetadata(i, j, k, 0);
	}

	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		return new ItemStack[]{new ItemStack(this, 1, 0)};
	}

	@Override
	public void onBlockClicked(World world, int i, int j, int k, EntityPlayer entityplayer) {
		if (world.getBlockMetadata(i, j, k) == 1)
			blockHardness(-1f);
		else
			blockHardness(1.1F);
	}

	private void blockHardness(float f) {
	}

}
