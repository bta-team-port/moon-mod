package teamport.moonmod.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import teamport.moonmod.item.MoonModItems;

public class BlockTent extends Block {
	public BlockTent(String key, int id, Material material) {
		super(key, id, Material.cloth);
	}

	@Override
	public void onBlockAdded(World world, int i, int j, int k) {
		world.setBlockMetadata(i, j, k, 0);
	}

	@Override
	public boolean blockActivated(World world, int i, int j, int k,
								  EntityPlayer entityPlayer) {
		int slot = entityPlayer.inventory.currentItem;
		ItemStack is = entityPlayer.inventory.mainInventory[slot];
		if (world.getBlockMetadata(i, j, k) == 1) {
			destroyTent(i, j, k, world, entityPlayer);
		} else {
			if (!checkBasis(i, j, k, entityPlayer, world))
				return false;
			buildTent(i, j, k, world);
		}
		return true;
	}

	private boolean checkBasis(int x, int y, int z, EntityPlayer ep, World world) {
		for (int i = x - 2; i < x + 2; i++) {
			for (int j = z - 3; j < z + 4; j++) {
				if (!world.getBlockMaterial(i, y, j).isSolid()) {
					ep.addChatMessage("Cannot build tent here.");
					return false;
				}
				for (int k = y + 1; k < y + 5; k++) {
					if (!world.isAirBlock(i, k, j)) {
						ep.addChatMessage("Cannot build tent here.");
						return false;
					}
				}
			}
		}
		return true;
	}

	private void buildTent(int x, int y, int z, World world) {
		int block;
		for (int k = 0; k < 5; k++) {
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 8; j++) {
					if (k == 0 && j == 4 && i == 3)
						continue;

					block = tentScheme[k][j][i];

					if (block <= 0)
						continue;
					world.setBlock(i + x - 3, k + y, j + z - 4, block);
					world.setBlockMetadata(i + x - 3, k + y, j + z - 4, 1);

					if (block == d) {
						int meta = 3;
						if (k > 1)
							meta = 11;
						world.setBlockMetadata(i + x - 3, k + y, j + z - 4, meta);
					}
				}
			}
		}
		world.setBlockMetadata(x, y, z, 1);
	}

	private void destroyTent(int x, int y, int z, World world, EntityPlayer ep) {
		world.setBlockMetadataWithNotify(x, y, z, 0);
		int block;
		for (int k = 0; k < 5; k++) {
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 8; j++) {
					if (tentScheme[k][j][i] == -1)
						continue;

					block = world.getBlockId(i + x - 3, k + y, j + z - 4);
					if (block == 0) {
						continue;
					} else if (block == this.id)
						continue;
					else if (block != tentScheme[k][j][i]) {
					}

					block = 0;
					if (k == 0) {
						block = world.getBlockId(x, y - 1, z);
					}
					world.setBlockWithNotify(i + x - 3, k + y, j + z - 4, block);
				}
			}
		}
	}

	private int b = MoonModBlocks.woolReinforced.id;
	private int d = Block.doorPlanksOakBottom.id;
	private int e = Block.doorPlanksOakTop.id;
	private int[][][] tentScheme = new int[][][] {
		new int[][] { new int[] { -1, b, b, b, b, b, -1 },
			new int[] { b, b, b, b, b, b, b },
			new int[] { b, b, b, b, b, b, b },
			new int[] { b, b, b, b, b, b, b },
			new int[] { b, b, b, b, b, b, b },
			new int[] { b, b, b, b, b, b, b },
			new int[] { -1, b, b, b, b, b, -1 },
			new int[] { -1, -1, b, b, b, -1, -1 } },

		new int[][] { new int[] { -1, b, b, b, b, b, -1 },
			new int[] { b, 0, 0, 0, 0, 0, b },
			new int[] { b, 0, 0, 0, 0, 0, b },
			new int[] { b, 0, 0,/**/0, 0, 0, b },
			new int[] { b, 0, 0, 0, 0, 0, b },
			new int[] { b, 0, 0, 0, 0, 0, b },
			new int[] { -1, b, 0, 0, 0, b, -1 },
			new int[] { -1, -1, b, d, b, -1, -1 } },

		new int[][] { new int[] { -1, b, b, b, b, b, -1 },
			new int[] { b, 0, 0, 0, 0, 0, b },
			new int[] { b, 0, 0, 0, 0, 0, b },
			new int[] { b, 0, 0, 0, 0, 0, b },
			new int[] { b, 0, 0, 0, 0, 0, b },
			new int[] { b, 0, 0, 0, 0, 0, b },
			new int[] { -1, b, 0, 0, 0, b, 0 },
			new int[] { -1, -1, b, e, b, -1, -1 } },

		new int[][] { new int[] { -1, -1, b, b, b, -1, -1 },
			new int[] { -1, b, 0, 0, 0, b, -1 },
			new int[] { -1, b, 0, 0, 0, b, -1 },
			new int[] { -1, b, 0, 0, 0, b, -1 },
			new int[] { -1, b, 0, 0, 0, b, -1 },
			new int[] { -1, b, 0, 0, 0, b, -1 },
			new int[] { -1, -1, b, b, b, -1, -1 },
			new int[] { -1, -1, -1, b, -1, -1, -1 } },

		new int[][] { new int[] { -1, -1, -1, -1, -1, -1, -1 },
			new int[] { -1, -1, b, b, b, -1, -1 },
			new int[] { -1, -1, b, b, b, -1, -1 },
			new int[] { -1, -1, b, b, b, -1, -1 },
			new int[] { -1, -1, b, b, b, -1, -1 },
			new int[] { -1, -1, b, b, b, -1, -1 },
			new int[] { -1, -1, -1, -1, -1, -1, -1 },
			new int[] { -1, -1, -1, -1, -1, -1, -1 } } };

}
