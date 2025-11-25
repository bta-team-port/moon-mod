package teamport.moonmod.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Share;
import com.llamalad7.mixinextras.sugar.ref.LocalIntRef;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.block.ItemBlock;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import teamport.moonmod.world.MoonDimension;

import java.util.HashMap;
import java.util.Map;

@Mixin(value = ItemBlock.class, remap = false)
public abstract class BlockBlacklistMixin {

    @Unique
    private static final Map<Integer, Integer> BLOCK_TO_BECOME = new HashMap<>();

    static {
        BLOCK_TO_BECOME.put(Blocks.PUMPKIN_CARVED_ACTIVE.id(), Blocks.PUMPKIN_CARVED_IDLE.id());
        BLOCK_TO_BECOME.put(Blocks.BRAZIER_ACTIVE.id(), Blocks.BRAZIER_INACTIVE.id());
        BLOCK_TO_BECOME.put(Blocks.PUMICE_WET.id(), Blocks.PUMICE_DRY.id());
        BLOCK_TO_BECOME.put(Blocks.COBBLE_NETHERRACK_IGNEOUS.id(), Blocks.COBBLE_NETHERRACK.id());
    }

    @Shadow
    @NonNull
    protected Block<?> block;

    @Definition(id = "stackSize", field = "Lnet/minecraft/core/item/ItemStack;stackSize:I")
    @Expression("?.stackSize <= 0")
    @ModifyExpressionValue(method = "onUseItemOnBlock", at = @At("MIXINEXTRAS:EXPRESSION"))
    private boolean banBlocksFromDimensionsOne(boolean original, ItemStack stack, @org.jspecify.annotations.Nullable Player player, World world, int x, int y, int z, Side side, double xPlaced, double yPlaced) {
        return original || world.dimension != MoonDimension.getMoon() && MoonDimension.getDimensionBlacklist(world.dimension).contains(block.id());
    }

    @Definition(id = "canPlaceInsideBlock", method = "Lnet/minecraft/core/world/World;canPlaceInsideBlock(III)Z")
    @Expression("?.canPlaceInsideBlock(?, ?, ?) == false")
    @ModifyExpressionValue(method = "onUseItemOnBlock", at = @At("MIXINEXTRAS:EXPRESSION"))
    private boolean banBlocksFromDimensionsTwo(boolean original, ItemStack stack, @Nullable Player player, World world, int x, int y, int z, Side side, double xPlaced, double yPlaced, @Share("replacementId") LocalIntRef replacementId) {
        replacementId.set(MoonDimension.getDimensionBlacklist(world.dimension).contains(block.id()) ? BLOCK_TO_BECOME.getOrDefault(block.id(), -2) : -1);
        return original;
    }

    @WrapOperation(method = "onUseItemOnBlock", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/world/World;canBlockBePlacedAt(IIIIZLnet/minecraft/core/util/helper/Side;)Z"))
    private boolean banBlocksFromDimensionsThree(World instance, int blockId, int x, int y, int z, boolean flag, Side side, Operation<Boolean> original, @Share("replacementId") LocalIntRef replacementId) {
        int id = replacementId.get();
        if (id == -2) return false;
        return original.call(instance, id == -1 ? blockId : id, x, y, z, flag, side);
    }

    @WrapOperation(method = "onUseItemOnBlock", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/world/World;setBlockAndMetadataWithNotify(IIIII)Z"))
    private boolean banBlocksFromDimensionsFour(World instance, int x, int y, int z, int id, int meta, Operation<Boolean> original, @Share("replacementId") LocalIntRef replacementId) {
        int theReplacementId = replacementId.get();
        return original.call(instance, x, y, z, theReplacementId == -1 ? id : theReplacementId, meta);
    }
}
