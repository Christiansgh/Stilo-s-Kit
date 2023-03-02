package elements.resources.factories;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import utils.ScreenBounds;

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
                Node background = createRectangle(rectangles.SIDEBARWINDOW);
                ScrollPane scrollPane = new ScrollPane(background);
                scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
                scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
                Node settingsWindow = new StackPane(scrollPane);
                return settingsWindow;
        
            default:
                Node defaultRectangle = new Rectangle();
                return defaultRectangle;
        }
    }
}
