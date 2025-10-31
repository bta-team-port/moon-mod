package teamport.moonmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.entity.particle.ParticleDispatcher;
import net.minecraft.client.entity.particle.ParticleFirefly;
import net.minecraft.client.render.worldtype.WorldTypeFXDispatcher;
import net.minecraft.client.sound.SoundRepository;
import teamport.moonmod.world.MoonWorldTypes;
import teamport.moonmod.world.WorldTypeFXMoon;
import turniplabs.halplibe.util.ClientStartEntrypoint;

import static teamport.moonmod.MoonMod.MOD_ID;

@Environment(EnvType.CLIENT)
public class MoonClient implements ClientModInitializer, ClientStartEntrypoint {

	@Override
	public void onInitializeClient() {
		MoonMod.LOGGER.info("MoonMod client initialized.");
	}

	@Override
	public void beforeClientStart() {
		ParticleDispatcher dispatcher = ParticleDispatcher.getInstance();

		dispatcher.addDispatch("fireflyWhite", (world, x, y, z, motionX, motionY, motionZ, data) -> new ParticleFirefly(world, x, y, z, motionX, motionY, motionZ, MoonMod.WHITE.getId()));

		SoundRepository.registerNamespace(MOD_ID);
	}

	@Override
	public void afterClientStart() {

		WorldTypeFXDispatcher.getInstance().addDispatch(new WorldTypeFXMoon(MoonWorldTypes.MOON_DEFAULT)
			.setCloudHeight(-100.0f)
			.setHasAurora(false)
			.setHasGround(true));

		WorldTypeFXDispatcher.getInstance().addDispatch(new WorldTypeFXMoon(MoonWorldTypes.MOON_RETRO)
			.setCloudHeight(100.0f)
			.setHasAurora(false)
			.setHasGround(true));

		WorldTypeFXDispatcher.getInstance().addDispatch(new WorldTypeFXMoon(MoonWorldTypes.MOON_SKYBLOCK)
			.setCloudHeight(100.0f)
			.setHasAurora(false)
			.setHasGround(true));
	}
}
