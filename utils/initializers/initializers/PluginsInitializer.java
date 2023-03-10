package initializers;

import elements.plugins.macros.Macros;
import elements.plugins.weakauras.WeakAuras;

public class PluginsInitializer {
    public static void initialize() {
        WeakAuras.getInstance().initialize();
        Macros.getInstance().initialize();
    }
}
