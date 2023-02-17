package elements.sidebar;

import elements.animators.Toggler;
import elements.fingerprinting.ScreenBounds;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Sidebar {
    private static AnchorPane sidebar = null;
    private static boolean isVisible = true;
    private Sidebar() {};

    public static AnchorPane getInstance() {
        if (sidebar == null) {
            Rectangle sidepaneBackground = new Rectangle(30,ScreenBounds.getHeight(), Color.web("#000000"));
            sidepaneBackground.setX(ScreenBounds.getWidth()-30);
            //Fit in a HBox here for the plugins.
            sidebar = new AnchorPane(sidepaneBackground);
            //sidebar.setOnMouseClicked(e -> sidebar.setVisible(false));
            sidebar.setOnMouseClicked(e -> {
                toggleSidebar();
            });
            return sidebar;
        }

        return sidebar;
    }

    public static void toggleSidebar() {
        isVisible = !isVisible;
        Toggler.toggle(getInstance(), isVisible);
    }
}
