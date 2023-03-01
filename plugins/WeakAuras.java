import api.Plugin;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public class WeakAuras extends Plugin {
    private static StackPane auraPopUps = null; //Icons that popup when event is triggered
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
            auraPopUps = new StackPane();
            weakAuras = new WeakAuras(isVisibleSettings, isVisiblePlugin, isActive, pluginIcon, windowSettings, windowPlugin);
        }
        return weakAuras;
    }

    private void addWeakAuraPopUp(Node icon) {
        auraPopUps.getChildren().add(icon);
        //asd
    }

    @Override
    public void initialize() {
        /*
         * Maybe make a class "WeakAura", that creates a new constructor. This constructor would have less parameters,
         * like the icon that is triggered, and the action event that triggers it.
         * 
         * Add the W/A icon to the sidebar.
         * 
         */
        
    }
}
