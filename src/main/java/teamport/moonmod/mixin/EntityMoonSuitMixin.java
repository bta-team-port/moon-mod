package teamport.moonmod.mixin;

import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import teamport.moonmod.blocks.MoonBlocks;
import teamport.moonmod.entity.MobUFO;
import teamport.moonmod.items.MoonItems;
import teamport.moonmod.world.ISpace;

@Mixin(value = Entity.class, remap = false)
public abstract class EntityMoonSuitMixin {

	@Shadow
	public double x;

	@Shadow
	public double y;

	@Shadow
	public double z;

	@Shadow
	@Nullable
	public World world;

	@Shadow
	public int airSupply;

	@Unique
	private boolean moonMod_hasSuit() {
		if (!((Object) this instanceof Mob)) return false;
		Mob thisAs = (Mob) (Object) this;
		for (int i = 0; i < 4; i++) {
			if (!(thisAs instanceof Player) || ((Player) thisAs).inventory.armorInventory[i] == null)
				return false;
		}

		return ((Player) thisAs).inventory.armorInventory[3].itemID == MoonItems.ARMOR_HELMET_MOON.id &&
			((Player) thisAs).inventory.armorInventory[2].itemID == MoonItems.ARMOR_CHESTPLATE_MOON.id &&
			((Player) thisAs).inventory.armorInventory[1].itemID == MoonItems.ARMOR_LEGGINGS_MOON.id &&
			((Player) thisAs).inventory.armorInventory[0].itemID == MoonItems.ARMOR_BOOTS_MOON.id;
	}

	@Inject(method = "isUnderLiquid", at = @At(value = "RETURN"), cancellable = true)
	public void moonMod_suffocate(Material material, CallbackInfoReturnable<Boolean> cir) {
		if (material != Material.water) return;
		if (!((Object) this instanceof Mob)) return;

		Mob living = (Mob) (Object) this;
		boolean shouldSuffocate = false;
		boolean isInside = false;

		for (int _x = (int) (x - 3); _x < x + 3; _x++) {
			for (int _y = (int) (y - 6); _y < y; _y++) {
				for (int _z = (int) (z - 3); _z < z + 3; _z++) {
					if (world.getBlockId(_x, _y, _z) == MoonBlocks.WOOL_REINFORCED.id()) isInside = true;
				}
			}
		}

		if (living.world.getWorldType() instanceof ISpace) {
			shouldSuffocate = ((ISpace) living.world.getWorldType()).suffocate() && !isInside;
		}

		if (!moonMod_hasSuit() && (shouldSuffocate || cir.getReturnValue() && !living.canBreatheUnderwater()) && !(living instanceof MobUFO)) {
			if (airSupply-- <= -20) airSupply = 0;

			cir.setReturnValue(true);
			return;
		}
		cir.setReturnValue(false);
	}
}
