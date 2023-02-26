package utils.initializers;

import elements.plugins.Macros;
import elements.plugins.logger.Logger;
import elements.regions.sidebar.Sidebar;

public class PluginsInitializer {
    //run Sidebar.addPlugin()
    public static void initialize() {
        Logger.getInstanceLogger().initialize();
        Sidebar.test();
        Macros.getInstanceMacros().initialize();
    }
}
