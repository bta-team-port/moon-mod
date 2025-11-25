package teamport.moonmod.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalIntRef;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemFireStriker;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import teamport.moonmod.world.MoonDimension;

@Mixin(value = ItemFireStriker.class, remap = false)
public abstract class FireStrikerBlacklistMixin extends Item {
    protected FireStrikerBlacklistMixin(NamespaceID namespaceId, int id) {
        super(namespaceId, id);
    }

    @WrapOperation(method = "onUseItemOnBlock", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/world/World;setBlockWithNotify(IIII)Z"))
    private boolean callOnItemUseOne(World instance, int x, int y, int z, int id, Operation<Boolean> original, ItemStack itemstack, Player entityplayer, World world, int blockXIgnore, int blockYIgnore, int blockZIgnore, Side side, double xPlaced, double yPlaced, @Local(name = "blockX") LocalIntRef blockX, @Local(name = "blockY") LocalIntRef blockY, @Local(name = "blockZ") LocalIntRef blockZ) {
        boolean isAether = instance.dimension == MoonDimension.getMoon();
        if (isAether) {
            blockX.set(blockX.get() - side.getOffsetX());
            blockY.set(blockY.get() - side.getOffsetY());
            blockZ.set(blockZ.get() - side.getOffsetZ());
        }
        return isAether || original.call(instance, x, y, z, id);
    }

}
