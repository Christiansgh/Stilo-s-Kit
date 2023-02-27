/*package plugins;

import api.Plugin;
import elements.regions.sidebar.Sidebar;
import elements.resources.factories.BoxFactory;
import elements.resources.factories.CircleFactory;
import elements.resources.factories.BoxFactory.boxTypeEnum;
import elements.resources.factories.CircleFactory.circleTypeEnum;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import plugins.logger.Logger;
import utils.ScreenBounds;

public class Macros extends Plugin {
    private boolean isVisible;
    private boolean isActive;
    private static VBox content = null;
    private static ScrollPane window = null;
    private static Macros macros = null;

    private Macros(boolean isVisible, boolean isActive, Node pluginIcon, Node pluginWindow) {
        super(isVisible, isActive, pluginIcon, pluginWindow);
    }

    public static Macros getInstanceMacros() {
        if (macros == null) {
            macros = new Macros(false, false, CircleFactory.createCircle(circleTypeEnum.btnPlaceHolder), getInstanceSettingsWindow());
            return macros;
        }

        return macros;
    }

    public static ScrollPane getInstanceSettingsWindow() {
        if (window == null) {
            /*
             * Prolly put these in a VBox then fill in with hboxes containing labels & toggleButtons.
             * Labels with:
             * - title
             * - boolean settings & label
             * - Drop down menus for other stuff.
             */
            /*StackPane stack = new StackPane(BoxFactory.createBox(boxTypeEnum.boxSettingsWindow), getInstanceSettingsContent());
            window = new ScrollPane(stack);
            window.setHbarPolicy(ScrollBarPolicy.NEVER);
            window.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
            window.setLayoutX(ScreenBounds.getWidth()-446);
            return window;
        }
        return window;
    }

    public static VBox getInstanceSettingsContent() {
        if (content == null) {
            content = new VBox(20);
            Label title = new Label("Macros");
            title.getStylesheets().add("/elements/css/base.css");
            title.getStyleClass().add("settingsContentTitle");
            //hbox: toggle & label w/ text //overlay active
            //hbox: toggle & label w/ text 
            content.getChildren().addAll(title);
            content.setAlignment(Pos.TOP_CENTER);
            return content;
        }

        return content;
    }

    @Override
    public void toggleVisible() {
        isVisible = !isVisible;
        pluginWindow.setVisible(isVisible);
    }

    @Override
    public void toggleActive() {
        
    }

    @Override
    public void initialize() {
        pluginWindow.setVisible(isVisible);
        Sidebar.addPlugin(pluginIcon, pluginWindow, getInstanceMacros());
    }
    
}
*/