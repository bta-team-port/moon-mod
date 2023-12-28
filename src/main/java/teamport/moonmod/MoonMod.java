package teamport.moonmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import net.minecraft.core.world.type.WorldType;
import net.minecraft.core.world.type.WorldTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import teamport.moonmod.world.BiomeProviderMoon;
import teamport.moonmod.world.ModDimensions;
import teamport.moonmod.world.WorldTypeMoon;
import teamport.moonmod.world.biome.MoonBiomes;
import teamport.moonmod.entity.EntityUFO;
import teamport.moonmod.entity.render.UFOModel;
import teamport.moonmod.entity.render.UFORenderer;
import teamport.moonmod.block.MoonModBlocks;
import teamport.moonmod.item.MoonModItems;
import net.minecraft.client.sound.block.BlockSound;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import teamport.moonmod.block.MoonModBlocks;
import teamport.moonmod.item.MoonModItems;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.EntityHelper;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;
import useless.dragonfly.helper.ModelHelper;


public class MoonMod implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint, PreLaunchEntrypoint {
  public static final String MOD_ID = "moonmod";
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
  public static WorldType MOON_WORLD;

  @Override
  public void onInitialize() {
	  new MoonModBlocks().initializeBlocks();
	  new MoonModItems().initializeItems();

	  EntityHelper.createEntity(EntityUFO.class,
		  new UFORenderer(ModelHelper.getOrCreateEntityModel(MOD_ID, "entity/ufo.json", UFOModel.class)),
		  300,
		  "UFO");

      LOGGER.info("MoonMod has been initialized. Have fun, brave astronaut!");
  }

	@Override
	public void beforeGameStart() {

	}

	@Override
	public void afterGameStart() {

	}

	@Override
	public void onRecipesReady() {

	}

	@Override
	public void onPreLaunch() {
		new MoonBiomes().initializeBiomes();
		BiomeProviderMoon.init();
		MOON_WORLD = WorldTypes.register(MoonMod.MOD_ID+":moon", new WorldTypeMoon("moonmod.worldtype.moon"));
	}
}
