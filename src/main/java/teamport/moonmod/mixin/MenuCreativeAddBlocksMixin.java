package teamport.moonmod.mixin;

import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.container.ContainerInventory;
import net.minecraft.core.player.inventory.menu.MenuInventory;
import net.minecraft.core.player.inventory.menu.MenuInventoryCreative;
import net.minecraft.core.util.helper.DyeColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import teamport.moonmod.blocks.MoonBlocks;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.core.player.inventory.menu.MenuInventoryCreative.creativeItems;
import static net.minecraft.core.player.inventory.menu.MenuInventoryCreative.creativeItemsCount;

@Mixin(value = MenuInventoryCreative.class, remap = false)
public class MenuCreativeAddBlocksMixin extends MenuInventory {

	@Inject(method = "<clinit>", at = @At("TAIL"))
	private static void injected(CallbackInfo ci) {
		List<ItemStack> newCreativeItems = new ArrayList<>();

		for (ItemStack item : creativeItems) {
			if (
				item.getMetadata() == 0
					&& (
					item.itemID == MoonBlocks.WOOL_REINFORCED.id())) {
				for (DyeColor dyeColor : DyeColor.blockOrderedColors()) {
					newCreativeItems.add(new ItemStack(item.itemID, 1, dyeColor.blockMeta));
				}
			} else newCreativeItems.add(item);
		}

		creativeItems = newCreativeItems;
		creativeItemsCount = creativeItems.size();
	}

	public MenuCreativeAddBlocksMixin(ContainerInventory inventory) {
		super(inventory);
	}
}
