package teamport.moonmod;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.SERVER)
public class MoonServer implements DedicatedServerModInitializer {
	@Override
	public void onInitializeServer() {
		MoonMod.LOGGER.info("MoonMod server initialized.");
	}
}
