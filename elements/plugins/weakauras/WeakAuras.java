package elements.plugins.weakauras;
import api.Plugin;
import elements.resources.factories.RectangleFactory;
import elements.resources.factories.RectangleFactory.rectangles;
import elements.skeleton.Sidebar;
import javafx.scene.Node;
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
        if (weakAuras == null) {                                                                     //resources.getSettingsWindowWeakAuras; Resources.getPluginWindowWeakAuras;
            auraPopUps = new StackPane();//Fix the constructor by manually implementing the params   //settings window //plugin window --> make class.
            weakAuras = new WeakAuras(false, false, false, new Circle(15, Color.AQUA), RectangleFactory.createRectangle(rectangles.SETTINGSWINDOW), RectangleFactory.createRectangle(rectangles.SETTINGSWINDOW));
            
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
        getInstance().addWindowPlugins();
        getInstance().addWindowSettings();
        /*
         * Implement WeakAura subclass here.
         * ie:
         * WeakAura overload = new WeakAura(overloadIconPath, overloadSoundPath, overloadRanOut);
         * overload.setOnoverloadRanOut(e -> activate);
         * overload.addWeakAuraPopup(overloadIconPath);
         */
        
    }
}
