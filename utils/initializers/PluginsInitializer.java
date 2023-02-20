package utils.initializers;

import elements.plugins.Logger;

public class PluginsInitializer {
    //run Sidebar.addPlugin()
    public static void initialize() {
        Logger.getInstanceLogger().initialize();
    }
}
