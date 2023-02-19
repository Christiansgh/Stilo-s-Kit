package elements.topbar.topbarIcons;

import elements.sidebar.Sidebar;
import elements.resources.Resources;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.SVGPath;
import javafx.scene.transform.Rotate;
import utils.Logger;

public class ToggleSidebar {
    private static boolean toggled = false;
    private static SVGPath icon = Resources.getIconToggleSidebar();
    private static StackPane toggleSidebar = null;
    private static Rotate rotate = new Rotate(0, 9, 10);
    
    public static StackPane getInstance() {
        if (toggleSidebar == null) {
            toggleSidebar = new StackPane(Resources.getButtonTopbar(), icon);
            toggleSidebar.setOnMouseClicked(e -> {
                toggle();
                Sidebar.toggleSidebar();
            });
            toggleSidebar.getTransforms().addAll(rotate);
            return toggleSidebar;
        }
        return toggleSidebar;
    }

    public static boolean isToggled() {
        return toggled;
    }

    public static void toggle() {
        toggled = !toggled;
        Sidebar.getInstance().setVisible(toggled);
        if (toggled) {
            rotate.setAngle(0);
            Logger.log("Toggled Sidebar: In\n");
        }
        else {
            rotate.setAngle(180);
            Logger.log("Toggled Sidebar: Out\n");
        }
    }
}
