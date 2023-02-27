package plugins;

import api.Plugin;
import javafx.scene.Node;

public class WeakAuras extends Plugin {
    private static Node auraPopUps = null; //Icons that popup when event is triggered
    private static int transitionTimeMillis;
    /*
     * Implement popups.
     * Start / end scale
     * stat / end opacity
     * transition time
     */
    private static WeakAuras weakAuras = null;
    private WeakAuras(boolean isVisibleSettings, boolean isVisiblePlugin, boolean isActive, Node pluginIcon, Node windowSettings, Node windowPlugins) {
        super(isVisibleSettings, isVisiblePlugin, isActive, pluginIcon, windowSettings, windowPlugins);
    }

    public WeakAuras getInstance() {
        if (weakAuras == null) {
            weakAuras = new WeakAuras(isVisibleSettings, isVisiblePlugin, isActive, pluginIcon, windowSettings, windowPlugin);
        }
        return weakAuras;
    }

    @Override
    public void initialize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }
}
