package teamport.moonmod.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.util.helper.DyeColor;
import net.minecraft.core.util.helper.Side;

import java.util.Iterator;

@Environment(EnvType.CLIENT)
public class BlockModelWoolReinforced<T extends BlockLogic> extends BlockModelStandard<T> {
	public static final IconCoordinate[] texCoords = new IconCoordinate[16];

	public BlockModelWoolReinforced(Block<T> block) {
		super(block);
	}

	public IconCoordinate getBlockTextureFromSideAndMetadata(Side side, int data) {
		return texCoords[data & 15];
	}

	static {
		DyeColor c;
		for (Iterator<DyeColor> var0 = DyeColor.blockOrderedColors().iterator(); var0.hasNext(); texCoords[c.blockMeta] = TextureRegistry.getTexture("moonmod:block/wool_reinforced/" + c.colorID)) {
			c = var0.next();
		}

	}
}
