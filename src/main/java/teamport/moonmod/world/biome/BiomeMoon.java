package teamport.moonmod.world.biome;

import net.minecraft.core.block.Block;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.weather.Weather;
import teamport.moonmod.block.MoonModBlocks;

public class BiomeMoon extends Biome {

	public BiomeMoon() {
		setBlockedWeathers(Weather.overworldRain, Weather.overworldStorm, Weather.overworldWinterSnow);
		setColor(0);
		setTopBlock(MoonModBlocks.regolith.id);
		setFillerBlock(MoonModBlocks.regolith.id);

		spawnableAmbientCreatureList.clear();
		spawnableCreatureList.clear();
		spawnableMonsterList.clear();
	}

	@Override
	public int getSkyColor(float temperature) {
		return 0;
	}
}
