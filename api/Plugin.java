package api;

import javafx.scene.Node;

public abstract class Plugin {
    protected boolean isVisible;
    protected boolean isActive;
    protected Node pluginIcon;
    protected Node pluginWindow;

    public Plugin(boolean isVisible, boolean isActive, Node pluginIcon, Node pluginWindow) {
        this.isVisible = isVisible;
        this.isActive = isActive;
        this.pluginIcon = pluginIcon;
        this.pluginWindow = pluginWindow;
    }

    public abstract void toggleVisible();
    
    public abstract void toggleActive();

    public abstract void initialize();
}
