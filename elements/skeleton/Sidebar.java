package elements.skeleton;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import utils.ScreenBounds;

public class Sidebar {
    private static boolean isVisible = true;
    private static AnchorPane sidebar = null;
    private static VBox pluginIcons;
    private Sidebar() {};

    public static AnchorPane getInstance() {
        if (sidebar == null) {
            //plugin icons
            pluginIcons = new VBox(20);

            //side bar itself
            sidebar = new AnchorPane();
            sidebar.setMinHeight(ScreenBounds.getHeight());
            sidebar.setPrefWidth(50);
            sidebar.getChildren().add(pluginIcons);
            sidebar.getStylesheets().add("/elements/resources/css/sidebar.css");
            sidebar.getStyleClass().add("background");
        }
        return sidebar;
    }

    public static void addPlugin(Node pluginIcon) {
        pluginIcons.getChildren().add(pluginIcon);
    }

    public static void toggleSidebarVisible() {
        isVisible = !isVisible;
        sidebar.setVisible(isVisible);
    }

    public static boolean getIsVisible() {
        return isVisible;
    }
}
