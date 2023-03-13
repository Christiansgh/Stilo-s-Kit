package elements.skeleton;

import javafx.scene.layout.HBox;
import javafx.scene.transform.Rotate;
import utils.misc.ScreenBounds;
import elements.general.ButtonTopbar;
import elements.general.PluginWindow;
import elements.resources.Resources;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Topbar {
    private static HBox topbarActivePlugins;
    private static HBox topbarIcons;
    private static Rotate rotate = new Rotate(0, 9, 10);
    private static AnchorPane topbar = null;
    private Topbar() {};
    
    public static AnchorPane getInstance() {
        if (topbar == null) {
            //logo + label
            HBox hbox = new HBox(15);
            ImageView logo = new ImageView(Resources.getLogo(20, 20));
            Label stilosKit = new Label("STILOS KIT");
            hbox.getChildren().addAll(logo, stilosKit);
            
            //active plugins
            topbarActivePlugins = new HBox(20);

            //topbar icons
            topbarIcons = new HBox(20);
            ButtonTopbar refresh = new ButtonTopbar(Resources.getIconRefresh());
            ButtonTopbar toggleSidebar = new ButtonTopbar(Resources.getIconToggleSidebar());
            ButtonTopbar close = new ButtonTopbar(Resources.getIconClose());
            topbarIcons.getChildren().addAll(refresh.getButtonTopbar(), toggleSidebar.getButtonTopbar(), close.getButtonTopbar());

            //icons event handling
            toggleSidebar.getButtonTopbar().setOnMouseClicked(e -> {
                Sidebar.toggleSidebarVisible();
                PluginWindow.hideWindows();
                if (Sidebar.getIsVisible()) {
                    rotate.setAngle(180);
                } else {
                    rotate.setAngle(0);
                }});
            toggleSidebar.getButtonTopbar().getTransforms().addAll(rotate); //rotates the icon when clicked

            close.getButtonTopbar().setOnMouseClicked(e -> System.exit(0));

            //topbar itself
            topbar = new AnchorPane();
            topbar.setPrefHeight(23);
            topbar.setMinWidth(ScreenBounds.getWidth());
            topbar.getChildren().addAll(hbox, topbarActivePlugins, topbarIcons);

            //anchor layout of topbar
            AnchorPane.setLeftAnchor(stilosKit, 30.0);
            AnchorPane.setTopAnchor(stilosKit, 2.0);
            AnchorPane.setRightAnchor(topbarIcons, 10.0);

            //style the elements with css
            topbar.getStylesheets().add("elements/resources/css/topbar.css");
            topbar.getStyleClass().addAll("background");
        }
        return topbar;
    }

    public static void addTopbarActivePlugin(Node pluginIcon) {
        topbarActivePlugins.getChildren().add(pluginIcon);
    }
}
