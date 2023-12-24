package teamport.moonmod.world.biome;

import net.minecraft.core.block.Block;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.weather.Weather;

public class BiomeMoon extends Biome {

	public BiomeMoon() {
		setBlockedWeathers(Weather.overworldRain, Weather.overworldStorm, Weather.overworldWinterSnow);
		setColor(0);
		setTopBlock(Block.gravel.id);
		setFillerBlock(Block.stone.id);

		spawnableAmbientCreatureList.clear();
		spawnableCreatureList.clear();
		spawnableMonsterList.clear();
	}

	@Override
	public int getSkyColor(float temperature) {
		return 0;
	}
}
