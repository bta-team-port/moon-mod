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
    private static final int MOON_DIMENSION_ID = MoonConfig.DIMENSION;
    private static final HashMap<Integer, List<Integer>> DIMENSION_PLACEMENT_BLACKLIST = new HashMap<>();
    public static Dimension MOON;
    private static boolean hasInit = false;

    public static List<Integer> getDimensionBlacklist(Dimension dimension) {
        return getDimensionBlacklist(dimension.id);
    }

    public static List<Integer> getDimensionBlacklist(Integer dimensionID) {
        return DIMENSION_PLACEMENT_BLACKLIST.computeIfAbsent(dimensionID, k -> new ArrayList<>());
    }

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
        Dimension.registerDimension(MOON_DIMENSION_ID, MOON);

        List<Integer> moonBlacklist = getDimensionBlacklist(MOON);
        moonBlacklist.add(Blocks.FIRE.id());
        moonBlacklist.add(Blocks.BRAZIER_ACTIVE.id());

        moonBlacklist.add(Blocks.FLUID_WATER_FLOWING.id());
        moonBlacklist.add(Blocks.FLUID_WATER_STILL.id());
        moonBlacklist.add(Blocks.FLUID_LAVA_FLOWING.id());
        moonBlacklist.add(Blocks.FLUID_LAVA_STILL.id());
        moonBlacklist.add(Blocks.TORCH_COAL.id());
        moonBlacklist.add(Blocks.PUMPKIN_CARVED_ACTIVE.id());
        moonBlacklist.add(Blocks.COBBLE_NETHERRACK_IGNEOUS.id());
        moonBlacklist.add(Blocks.PUMICE_WET.id());
        moonBlacklist.add(Blocks.PORTAL_NETHER.id());

    }

    public static Dimension getMoon() {
        return MOON;
    }

}

