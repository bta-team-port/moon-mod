package teamport.moonmod.entity;

import com.mojang.nbt.tags.CompoundTag;
import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.entity.animal.Creature;
import net.minecraft.core.entity.animal.MobAnimal;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;
import teamport.moonmod.blocks.MoonBlocks;
import teamport.moonmod.items.MoonItems;

public class MobUFO extends MobAnimal implements Creature {

	public MobUFO(World world) {
		super(world);
		this.textureIdentifier = NamespaceID.getPermanent("moonmod", "ufo");
		this.setSize(0.5F, 1.0F);
		this.mobDrops.add(new WeightedRandomLootObject(MoonItems.CHEESE.getDefaultStack(), 1, 2));
	}

	public int getMaxSpawnedInChunk() {
		return 4;
	}

	protected float getBlockPathWeight(int x, int y, int z) {
		return this.world.getBlockId(x, y - 1, z) == MoonBlocks.REGOLITH.id() ? 10.0F : this.world.getLightBrightness(x, y, z) - 0.5F;
	}

	@Override
	public boolean canSpawnHere() {
		int x = MathHelper.floor(this.x);
		int y = MathHelper.floor(this.bb.minY);
		int z = MathHelper.floor(this.z);
		int id = this.world.getBlockId(x, y - 1, z);
		if (Blocks.blocksList[id] == null) {
			return false;
		} else {
			return id == MoonBlocks.REGOLITH.id();
		}
	}

	public void addAdditionalSaveData(@NotNull CompoundTag tag) {
		super.addAdditionalSaveData(tag);
	}

	public void readAdditionalSaveData(@NotNull CompoundTag tag) {
		super.readAdditionalSaveData(tag);
	}

	public int getAmbientSoundInterval() {
		return 480 / 2;
	}

	public String getLivingSound() {
		return "moonmod:alien.idle";
	}

	public String getHurtSound() {
		return "moonmod:alien.hurt";
	}

	public String getDeathSound() {
		return "moonmod:alien.death";
	}

	public float getSoundVolume() {
		return 0.4F;
	}

	public boolean isFavouriteItem(ItemStack itemStack) {
		return itemStack != null && itemStack.getItem().equals(MoonItems.CHEESE);
	}
}
