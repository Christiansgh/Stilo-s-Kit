package elements.regions.sidebar;

import api.Plugin;
import elements.plugins.weakauras.WeakAuras;
import elements.resources.Resources;
import elements.resources.factories.BoxFactory;
import elements.resources.factories.CircleFactory;
import elements.resources.factories.BoxFactory.boxTypeEnum;
import elements.resources.factories.CircleFactory.circleTypeEnum;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import utils.ScreenBounds;

public class Sidebar {
    private static AnchorPane sidebar = null;
    private static VBox sidebarPlugins = null;
    private Sidebar() {};

    public static AnchorPane getInstanceSidebar() {
        if (sidebar == null) {
            sidebar = new AnchorPane(BoxFactory.createBox(boxTypeEnum.boxSidebar), getInstanceSidebarPlugins());
            AnchorPane.setTopAnchor(getInstanceSidebarPlugins(), 30.0);
            AnchorPane.setRightAnchor(getInstanceSidebarPlugins(), 5.0);
            return sidebar;
        }

        return sidebar;
    }

    public static VBox getInstanceSidebarPlugins() {
        if (sidebarPlugins == null) {
            sidebarPlugins = new VBox(20);
            sidebarPlugins.setLayoutX(ScreenBounds.getWidth()-45);
            sidebarPlugins.setAlignment(Pos.CENTER);
        }

        return sidebarPlugins;
    }

    public static void addPlugin(Node pluginImage, Node pluginWindow, Plugin plugin) {
        pluginImage.setOnMouseClicked(e -> {plugin.toggleVisible();});
        getInstanceSidebarPlugins().getChildren().add(pluginImage);
    }

    public static void test() {
        WeakAuras weakAurasTest = new WeakAuras(Resources.getItemOverload(), 25, 0, 0.2, 500);
        weakAurasTest.initialize();
        
        //event handler
        Circle btnTest = CircleFactory.createCircle(circleTypeEnum.btnPlaceHolder);
        btnTest.setOnMouseClicked(e -> weakAurasTest.activate("overload.mp3"));
        getInstanceSidebarPlugins().getChildren().add(btnTest);
    }
}
