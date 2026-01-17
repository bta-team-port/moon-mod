package teamport.moonmod.world.chunk.skyblock;

import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.entity.TileEntityChest;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.chunk.Chunk;
import net.minecraft.core.world.generate.chunk.ChunkDecorator;
import teamport.moonmod.items.MoonItems;

public class ChunkDecoratorSkyblockMoon implements ChunkDecorator {
    public ChunkDecoratorSkyblockMoon() {
    }

    public void decorate(Chunk chunk) {
        int z;
        for (z = 0; z <= 1; ++z) {
            if (this.contains(chunk, 2, z)) {
                chunk.setBlockMetadata(2, 67, z & 15, 1);
                chunk.setBlockMetadata(2, 68, z & 15, 1);
                chunk.setBlockMetadata(2, 69, z & 15, 1);
            }
        }

        TileEntity tileEntity;
        TileEntityChest chestEntity;
        if (this.contains(chunk, -2, 0)) {
            chunk.setBlockIDWithMetadata(14, 67, 0, Blocks.CHEST_PLANKS_OAK_PAINTED.id(), 1);
            tileEntity = chunk.getTileEntity(14, 67, 0);
            if (tileEntity instanceof TileEntityChest) {
                chestEntity = (TileEntityChest) tileEntity;
                chestEntity.setItem(0, new ItemStack(MoonItems.CHEESE, 1));
            }
        }
    }

    private boolean contains(Chunk chunk, int xBlock, int zBlock) {
        return chunk.xPosition == xBlock >> 4 && chunk.zPosition == zBlock >> 4;
    }
}
