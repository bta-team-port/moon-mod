package teamport.moonmod.world;

public class MoonWorldFeatures {

    private static boolean hasInit = false;

    public static void init() {
        if (!hasInit) {
            hasInit = true;
            initializeWorldFeatures();
        }

    }

    private static void initializeWorldFeatures() {

    }
}
