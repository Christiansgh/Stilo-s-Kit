package elements.resources.factories;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import utils.misc.ScreenBounds;

public class RectangleFactory {
    public enum rectangles {
        SIDEBARWINDOW,
        SETTINGSWINDOW,
        PLUGINWINDOW
    }

    public static Node createRectangle(rectangles type) {
        switch (type) {
            case SIDEBARWINDOW:
                Node sidebarWindow = new Rectangle(450, ScreenBounds.getHeight());
                sidebarWindow.setStyle("-fx-fill: #333333;");
                return sidebarWindow;

            case SETTINGSWINDOW:
                Node backgroundSettingsWindow = createRectangle(rectangles.SIDEBARWINDOW);
                ScrollPane scrollPaneSettingsWindow = new ScrollPane(backgroundSettingsWindow);
                scrollPaneSettingsWindow.setHbarPolicy(ScrollBarPolicy.NEVER);
                scrollPaneSettingsWindow.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
                Node settingsWindow = new StackPane(scrollPaneSettingsWindow);
                return settingsWindow;

            case PLUGINWINDOW:
                Node backgroundPluginWindow = createRectangle(rectangles.SIDEBARWINDOW);
                ScrollPane scrollPanePluginWindow = new ScrollPane(backgroundPluginWindow);
                scrollPanePluginWindow.setHbarPolicy(ScrollBarPolicy.NEVER);
                scrollPanePluginWindow.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
                Node pluginWindow = new StackPane(scrollPanePluginWindow);
                return pluginWindow;
        
            default:
                Node defaultRectangle = new Rectangle();
                return defaultRectangle;
        }
    }
}
