package utils.initializers;

import elements.plugins.logger.Logger;

public class PluginsInitializer {
    //run Sidebar.addPlugin()
    public static void initialize() {
        Logger.getInstanceLogger().initialize();
    }
}
