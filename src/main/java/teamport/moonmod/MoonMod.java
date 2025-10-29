package teamport.moonmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.entity.animal.MobFireflyCluster;
import net.minecraft.core.sound.SoundTypes;
import net.minecraft.core.world.biome.Biome;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import teamport.moonmod.blocks.MoonBlockDetails;
import teamport.moonmod.blocks.MoonBlocks;
import teamport.moonmod.entity.MoonEntities;
import teamport.moonmod.items.MoonItems;
import teamport.moonmod.world.MoonBiomes;
import teamport.moonmod.world.MoonDimension;
import teamport.moonmod.world.MoonWorldFeatures;
import turniplabs.halplibe.util.GameStartEntrypoint;

import static net.minecraft.core.entity.animal.MobFireflyCluster.FireflyColor.register;


public class MoonMod implements GameStartEntrypoint, ModInitializer {
	public static final String MOD_ID = "moonmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static String versionString = FabricLoader.getInstance().getModContainer(MOD_ID).get().getMetadata().getVersion().getFriendlyString();
	public static String state = "alpha";
	public static MobFireflyCluster.FireflyColor WHITE;

	@Override
	public void onInitialize() {
		LOGGER.info("MoonMod has been initialized. Have fun, brave astronaut! Version {} {}", state, versionString);
	}

	@Override
	public void beforeGameStart() {
		MoonConfig.Setup();
		MoonEntities.init();
		MoonBlocks.init();
		MoonItems.init();
		MoonDimension.init();
		MoonWorldFeatures.init();

		WHITE = register(new MobFireflyCluster.FireflyColor(10, "fireflySilver", new Biome[]{MoonBiomes.LUNAR_PLAINS}, new float[]{1.0F, 1.0F, 1.0F}));

		SoundTypes.loadSoundsJson(MOD_ID);
	}

	@Override
	public void afterGameStart() {
		MoonBlockDetails.initializeBlockDetails();
	}
}
