package elements.plugins.macros;

import api.Plugin;
import elements.general.PluginWindow;
import elements.resources.Resources;
import elements.skeleton.Sidebar;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Macros extends Plugin {
    private boolean isVisible;
    private boolean isActive;
    private static Macros macros = null;

    private Macros(boolean isVisibleSettings, boolean isVisiblePlugin, boolean isActive, Node pluginIcon, Node windowSettings, Node windowPlugins) {
        super(isVisibleSettings, isVisiblePlugin, isActive, pluginIcon, windowSettings, windowPlugins);
    }

    public static Macros getInstance() {
        if (macros == null) {
            StackPane icon = new StackPane(new Circle(15, Color.GREEN), new ImageView (Resources.getMacros()));
            macros = new Macros(false, false, false, icon, PluginWindow.getMacrosPluginWindow(), PluginWindow.getMacrosPluginWindow());
            return macros;
        }

        return macros;
    }

    @Override
    public void toggleActive() {
        
    }

    @Override
    public void initialize() {
        Sidebar.addPlugin(pluginIcon);
        pluginIcon.setOnMouseClicked(e -> getInstance().toggleVisibleSettings());
        getInstance().addWindowPlugins();
        getInstance().addWindowSettings();
        getInstance().windowPlugin.setVisible(isVisiblePlugin);
        getInstance().windowSettings.setVisible(isVisibleSettings);
    }
    
}
