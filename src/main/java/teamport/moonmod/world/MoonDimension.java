package teamport.moonmod.world;

import net.minecraft.core.block.Blocks;
import net.minecraft.core.world.Dimension;
import teamport.moonmod.MoonConfig;
import teamport.moonmod.blocks.MoonBlocks;
import teamport.moonmod.world.chunk.BiomeProviderMoon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MoonDimension {
	public static int MoonDimensionID = MoonConfig.DIMENSION;
	public static final HashMap<Integer, List<Integer>> dimensionPlacementBlacklist = new HashMap<>();

	public static List<Integer> getDimensionBlacklist(Dimension dimension) {
		return getDimensionBlacklist(dimension.id);
	}

	public static List<Integer> getDimensionBlacklist(Integer dimensionID) {
		if (!dimensionPlacementBlacklist.containsKey(dimensionID)) {
			dimensionPlacementBlacklist.put(dimensionID, new ArrayList<>());
		}
		return dimensionPlacementBlacklist.get(dimensionID);
	}

	public static Dimension MOON;

	private static boolean hasInit = false;

	public static void init() {
		if (!hasInit) {
			hasInit = true;
			initializeDimension();
		}

	}

	public static void initializeDimension() {
		MoonBiomes.init();
		MoonWorldTypes.init();
		BiomeProviderMoon.init();

		MOON = new Dimension("moon", Dimension.OVERWORLD, 0.25f, MoonBlocks.PORTAL_MOON, MoonWorldTypes.MOON_DEFAULT);
		Dimension.registerDimension(MoonDimensionID, MOON);

		List<Integer> MOON_BLACKLIST = getDimensionBlacklist(MOON);
		MOON_BLACKLIST.add(Blocks.FIRE.id());
		MOON_BLACKLIST.add(Blocks.BRAZIER_ACTIVE.id());

		MOON_BLACKLIST.add(Blocks.FLUID_WATER_FLOWING.id());
		MOON_BLACKLIST.add(Blocks.FLUID_WATER_STILL.id());
		MOON_BLACKLIST.add(Blocks.FLUID_LAVA_FLOWING.id());
		MOON_BLACKLIST.add(Blocks.FLUID_LAVA_STILL.id());
		MOON_BLACKLIST.add(Blocks.TORCH_COAL.id());
		MOON_BLACKLIST.add(Blocks.PUMPKIN_CARVED_ACTIVE.id());
		MOON_BLACKLIST.add(Blocks.COBBLE_NETHERRACK_IGNEOUS.id());
		MOON_BLACKLIST.add(Blocks.PUMICE_WET.id());
		MOON_BLACKLIST.add(Blocks.PORTAL_NETHER.id());

	}

}

