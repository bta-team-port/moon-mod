package teamport.moonmod.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;

public class BlockReinforcedWool extends Block {

	public BlockReinforcedWool(String key, int id, Material material) {
		super(key, id, Material.cloth);
	}

	public static int getMetadataForColour(int i) {
		return ~i & 15;
	}

}
