package teamport.moonmod.world;

import net.minecraft.core.entity.SpawnListEntry;
import net.minecraft.core.entity.animal.MobFireflyCluster;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.weather.Weathers;
import teamport.moonmod.blocks.MoonBlocks;
import teamport.moonmod.entity.MobUFO;

public class BiomeMoon extends Biome {
	public BiomeMoon(String key) {
		super(key);
		setColor(0);
		setBlockedWeathers(Weathers.WEATHERS);
		setTopBlock(MoonBlocks.REGOLITH.id());
		setFillerBlock(MoonBlocks.REGOLITH.id());
		setBlockedWeathers(Weathers.OVERWORLD_RAIN, Weathers.OVERWORLD_SNOW, Weathers.OVERWORLD_STORM);

		spawnableAmbientCreatureList.clear();
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		spawnableMonsterList.clear();

		this.spawnableCreatureList.add(new SpawnListEntry(MobUFO.class, 102));

		this.spawnableAmbientCreatureList.add(new SpawnListEntry(MobFireflyCluster.class, 30));
	}

	public int getSkyColor(float temperature) {
		return 0;
	}

}
