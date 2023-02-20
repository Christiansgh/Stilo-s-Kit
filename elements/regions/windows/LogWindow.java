package elements.regions.windows;

import elements.plugins.Logger;
import elements.resources.factories.BoxFactory;
import elements.resources.factories.BoxFactory.boxTypeEnum;
import javafx.scene.layout.StackPane;

public class LogWindow {
    private static StackPane logWindow = null;
    private LogWindow() {};

    public static StackPane getInstance() {
        if (logWindow == null) {
            logWindow = new StackPane(BoxFactory.createBox(boxTypeEnum.boxLogging), Logger.getInstanceLogs());
            return logWindow;
        }

        return logWindow;
    }
}
