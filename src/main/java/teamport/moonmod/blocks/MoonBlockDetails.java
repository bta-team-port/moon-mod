package teamport.moonmod.blocks;

import net.minecraft.core.block.material.MaterialColor;

import static net.minecraft.core.block.material.MaterialColor.registerManualBlockColor;

public class MoonBlockDetails {

	public static void initializeBlockDetails() {
		registerBlockInstruments();
		registerNewFurnaceFuel();
		registerMapColors();
		registerMossMap();
	}

	public static void registerNewFurnaceFuel() {
	}

	public static void registerBlockInstruments() {
	}

	public static void registerMossMap() {
	}

	public static void registerMapColors() {
		registerManualBlockColor(MoonBlocks.PORTAL_MOON, 0, MaterialColor.paintedLightblue);

		for (int i = 0; i < 256; ++i) {
			int colorIndex = i % 16;
			registerManualBlockColor(MoonBlocks.WOOL_REINFORCED, i, PAINTED_COLORS[colorIndex]);
		}

	}

	public static final MaterialColor[] PAINTED_COLORS = {
		MaterialColor.paintedWhite,
		MaterialColor.paintedOrange,
		MaterialColor.paintedMagenta,
		MaterialColor.paintedLightblue,
		MaterialColor.paintedYellow,
		MaterialColor.paintedLime,
		MaterialColor.paintedPink,
		MaterialColor.paintedGrey,
		MaterialColor.paintedSilver,
		MaterialColor.paintedCyan,
		MaterialColor.paintedPurple,
		MaterialColor.paintedBlue,
		MaterialColor.paintedBrown,
		MaterialColor.paintedGreen,
		MaterialColor.paintedRed,
		MaterialColor.paintedBlack
	};
}
