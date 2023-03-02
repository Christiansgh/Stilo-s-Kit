package api;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public abstract class Plugin {
    protected boolean isVisibleSettings;
    protected boolean isVisiblePlugin;
    protected boolean isActive;
    protected Node pluginIcon;
    protected Node windowSettings;
    protected Node windowPlugin;

    protected static StackPane settingsStack = new StackPane(); //Stack of all the settings windows.
    protected static StackPane pluginsStack = new StackPane(); //Stack of all the customization windows.

    public Plugin(boolean isVisibleSettings, boolean isVisiblePlugin, boolean isActive, Node pluginIcon, Node windowSettings, Node windowPlugin) {
        this.isVisibleSettings = isVisibleSettings;
        this.isVisiblePlugin = isVisiblePlugin;
        this.isActive = isActive;
        this.pluginIcon = pluginIcon;
        this.windowSettings = windowSettings;
        this.windowPlugin = windowPlugin;
    }

    protected void addWindowSettings() {
        settingsStack.getChildren().add(windowSettings);
    }

    protected void addWindowPlugins() {
        pluginsStack.getChildren().add(windowPlugin);
    }

    public void toggleVisibleSettings() {
        isVisibleSettings = !isVisibleSettings;
        windowSettings.setVisible(isVisibleSettings);
    }

    public void toggleVisiblePlugins() {
        isVisiblePlugin = !isVisiblePlugin;
    }
    
    public void toggleActive() {

    }

    public abstract void initialize();

    public static StackPane getSettingsStack() {
        return settingsStack;
    }

    public static StackPane getPluginsStack() {
        return pluginsStack;
    }
}
