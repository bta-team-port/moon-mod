package teamport.moonmod.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockPortal;
import net.minecraft.core.world.World;

public class BlockPortalMoon extends BlockPortal {
	public BlockPortalMoon(String key, int id, int targetDimension, int portalMaterialId, int portalTriggerId) {
		super(key, id, targetDimension, portalMaterialId, portalTriggerId);
	}

	public boolean tryToCreatePortal(World var1, int var2, int var3, int var4) {
		var3++;
		byte var5 = 0;
		byte var6 = 0;
		if (var1.getBlockId(var2 - 1, var3, var4) == MoonModBlocks.cheese.id
			|| var1.getBlockId(var2 + 1, var3, var4) == MoonModBlocks.cheese.id) {
			var5 = 1;
		}

		if (var1.getBlockId(var2, var3, var4 - 1) == MoonModBlocks.cheese.id
			|| var1.getBlockId(var2, var3, var4 + 1) == MoonModBlocks.cheese.id) {
			var6 = 1;
		}

		if (var5 == var6) {
			return false;
		} else {
			if (var1.getBlockId(var2 - var5, var3, var4 - var6) == 0) {
				var2 -= var5;
				var4 -= var6;
			}

			int var7;
			int var8;
			for (var8 = -1; var8 <= 2; ++var8) {
				for (var7 = -1; var7 <= 3; ++var7) {
					boolean var9 = var8 == -1 || var8 == 2 || var7 == -1
						|| var7 == 3;
					if (var8 != -1 && var8 != 2 || var7 != -1 && var7 != 3) {
						int var10 = var1.getBlockId(var2 + var5 * var8, var3
							+ var7, var4 + var6 * var8);
						if (var9) {
							if (var10 != MoonModBlocks.cheese.id) {
								return false;
							}
						} else if (var10 != 0 && var10 != Block.fire.id) {
							return false;
						}
					}
				}
			}

			var1.editingBlocks = true;

			for (var8 = 0; var8 < 2; ++var8) {
				for (var7 = 0; var7 < 3; ++var7) {
					var1.setBlockWithNotify(var2 + var5 * var8, var3 + var7,
						var4 + var6 * var8, this.id);
				}
			}

			var1.editingBlocks = false;
			return true;
		}
	}

}
