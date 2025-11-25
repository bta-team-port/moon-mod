package teamport.moonmod.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.BlockLogicFire;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import teamport.moonmod.world.MoonDimension;

@Mixin(value = BlockLogicFire.class, remap = false)
public abstract class BlockFireBlacklistMixin extends BlockLogic {
    protected BlockFireBlacklistMixin(Block<?> block, Material material) {
        super(block, material);
    }

    @WrapMethod(method = "onBlockPlacedByWorld")
    private void onBlockPlacedByWorld(World world, int x, int y, int z, Operation<Void> original) {
        if (world.dimension == MoonDimension.getMoon()) {
            world.setBlock(x, y, z, 0);
            return;
        }
        original.call(world, x, y, z);
    }
}
