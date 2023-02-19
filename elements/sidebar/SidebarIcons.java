package elements.sidebar;

import elements.animators.Toggler;
import elements.fingerprinting.ScreenBounds;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class SidebarIcons {
    private static VBox sidebarIcons = null;
    private SidebarIcons() {};

    public static VBox getInstance() {
        if (sidebarIcons == null) {
            sidebarIcons = new VBox(20);
            sidebarIcons.setLayoutX(ScreenBounds.getWidth()-25);
            return sidebarIcons;
        }

        return sidebarIcons;
    }

    public static void addSidebarIcon(Node node) {
        getInstance().getChildren().add(node);
    }

    public static void toggleWindow(Node window, boolean startState) {
        //System.out.println("Toggled" +window);
        Toggler.toggle(window, startState);
    }
}
