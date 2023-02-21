package elements.regions.topbar.topbarIcons;

import elements.plugins.logger.Logger;
import elements.regions.sidebar.Sidebar;
import elements.resources.Resources;
import elements.resources.factories.CircleFactory;
import elements.resources.factories.CircleFactory.circleTypeEnum;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.SVGPath;
import javafx.scene.transform.Rotate;

public class ToggleSidebar {
    private static boolean toggled = false;
    private static SVGPath icon = Resources.getIconToggleSidebar();
    private static StackPane toggleSidebar = null;
    private static Rotate rotate = new Rotate(0, 9, 10);
    
    public static StackPane getInstance() {
        if (toggleSidebar == null) {
            toggleSidebar = new StackPane(CircleFactory.createCircle(circleTypeEnum.btnTopbar), icon);
            toggleSidebar.setOnMouseClicked(e -> {
                toggle();
            });
            toggleSidebar.getTransforms().addAll(rotate);
            return toggleSidebar;
        }
        return toggleSidebar;
    }

    public static void toggle() {
        toggled = !toggled;
        Sidebar.getInstanceSidebar().setVisible(toggled);
        if (toggled) {
            rotate.setAngle(0);
            Logger.getInstanceLogger().log("Hid the sidebar\n");
        }
        else {
            rotate.setAngle(180);
            Logger.getInstanceLogger().log("Showed the sidebar\n");
        }
    }
}
