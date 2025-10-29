package teamport.moonmod.entity;

import net.minecraft.core.util.collection.NamespaceID;
import turniplabs.halplibe.helper.EntityHelper;

import static teamport.moonmod.MoonMod.MOD_ID;

public final class MoonEntities {
	private static boolean hasInit = false;

	public static void init() {
		if (!hasInit) {
			hasInit = true;
			initializeEntities();
		}

	}

	public static String entityKey(String string) {
		return MOD_ID + ".entity." + string;
	}

	public static void initializeEntities() {
		EntityHelper.createEntity(MobUFO.class, NamespaceID.getPermanent(MOD_ID, "ufo"), entityKey("ufo"));
	}
}
