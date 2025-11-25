package teamport.moonmod.world.chunk.skyblock;

import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.chunk.ChunkGenerator;
import net.minecraft.core.world.type.WorldType;
import teamport.moonmod.world.WorldTypeMoon;

public class WorldTypeMoonSkyblock extends WorldTypeMoon {
    public WorldTypeMoonSkyblock(WorldType.Properties properties) {
        super(properties);
    }

    public ChunkGenerator createChunkGenerator(World world) {
        return new ChunkGeneratorSkyblockMoon(world);
    }
}
