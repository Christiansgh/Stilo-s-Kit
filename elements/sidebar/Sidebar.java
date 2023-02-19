package elements.sidebar;

import elements.animators.Toggler;
import elements.resources.box.BoxFactory;
import elements.resources.box.BoxFactory.boxTypeEnum;
import javafx.scene.layout.AnchorPane;

public class Sidebar {
    private static AnchorPane sidebar = null;
    private static boolean isVisible = true;
    private Sidebar() {};

    public static AnchorPane getInstance() {
        if (sidebar == null) {
            sidebar = new AnchorPane(BoxFactory.createBox(boxTypeEnum.boxSidebar), SidebarIcons.getInstance());
            AnchorPane.setTopAnchor(SidebarIcons.getInstance(), 30.0);
            return sidebar;
        }

        return sidebar;
    }

    public static void toggleSidebar() {
        isVisible = !isVisible;
        Toggler.toggle(getInstance(), isVisible);
    }
}
