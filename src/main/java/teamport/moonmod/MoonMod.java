package teamport.moonmod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.GameStartEntrypoint;


public class MoonMod implements GameStartEntrypoint, ModInitializer {
	public static final String MOD_ID = "moonmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("MoonMod has been initialized. Have fun, brave astronaut!");
	}

	@Override
	public void beforeGameStart() {
	}

	@Override
	public void afterGameStart() {
	}
}
