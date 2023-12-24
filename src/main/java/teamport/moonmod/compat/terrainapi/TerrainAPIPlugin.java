package teamport.moonmod.compat.terrainapi;

import teamport.moonmod.MoonMod;
import useless.terrainapi.api.TerrainAPI;

public class TerrainAPIPlugin implements TerrainAPI {

	@Override
	public String getModID() {
		return MoonMod.MOD_ID;
	}

	@Override
	public void onInitialize() {
		new MoonInitialization().init();
	}
}
