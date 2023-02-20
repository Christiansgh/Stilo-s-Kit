package elements.logwindow;

import elements.resources.box.BoxFactory;
import elements.resources.box.BoxFactory.boxTypeEnum;
import elements.sidebar.SidebarIcons;
import javafx.scene.layout.StackPane;
import utils.Logger;

public class LogWindow {
    private static boolean isVisible = true;
    private static StackPane logWindow = null;
    private LogWindow() {};

    public static StackPane getInstance() {
        if (logWindow == null) {
            logWindow = new StackPane(BoxFactory.createBox(boxTypeEnum.boxLogging), Logger.getInstance());
            return logWindow;
        }

        return logWindow;
    }
    
    public static void toggleLogWindow() {
        isVisible = !isVisible;
        SidebarIcons.toggleSidebarWindow(logWindow, isVisible);
        Logger.log("Toggled Log window\n");
    }
}
