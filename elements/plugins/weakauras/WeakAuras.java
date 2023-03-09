package elements.plugins.weakauras;
import api.Plugin;
import elements.general.PluginWindow;
import elements.resources.Resources;
import elements.skeleton.Sidebar;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

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
    public WeakAuras(boolean isVisibleSettings, boolean isVisiblePlugin, boolean isActive, Node pluginIcon, Node windowSettings, Node windowPlugins) {
        super(isVisibleSettings, isVisiblePlugin, isActive, pluginIcon, windowSettings, windowPlugins);
    }

    public static WeakAuras getInstance() {
        if (weakAuras == null) {                      
            ImageView listIcon;                                               //resources.getSettingsWindowWeakAuras; Resources.getPluginWindowWeakAuras;
            StackPane icon = new StackPane(new Circle(15, Color.AQUA), listIcon = new ImageView(Resources.getWA()));
            auraPopUps = new StackPane();//Fix the constructor by manually implementing the params   //settings window //plugin window --> make class.
            weakAuras = new WeakAuras(false, false, false, icon, PluginWindow.getWeakAurasPluginWindow(), PluginWindow.getWeakAurasPluginWindow());
            
        }
        return weakAuras;
    }

    private void addWeakAuraPopUp(Node icon) {
        auraPopUps.getChildren().add(icon);
    }

    @Override
    public void initialize() {
        Sidebar.addPlugin(pluginIcon);
        pluginIcon.setOnMouseClicked(e -> getInstance().toggleVisibleSettings());
        //Build settings window
        getInstance().addWindowPlugins();
        getInstance().addWindowSettings();
        getInstance().windowPlugin.setVisible(isVisiblePlugin);
        getInstance().windowSettings.setVisible(isVisibleSettings);
        /*
         * Implement WeakAura subclass here.
         * ie:
         * WeakAura overload = new WeakAura(overloadIconPath, overloadSoundPath, overloadRanOut);
         * overload.setOnoverloadRanOut(e -> activate);
         * overload.addWeakAuraPopup(overloadIconPath);
         */
        
    }
}
