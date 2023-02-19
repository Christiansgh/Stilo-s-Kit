package elements.topbar.topbarIcons;

import elements.resources.Resources;
import javafx.scene.layout.StackPane;
import utils.Logger;

public class Refresh {
    private static StackPane refresh = null;
    private Refresh() {};

    public static StackPane getInstance() {
        if (refresh == null) {
            StackPane refresh = new StackPane(Resources.getButtonTopbar(), Resources.getIconRefresh());
            refresh.setOnMouseClicked(e -> refresh());
            return refresh;
        }

        return refresh;
    }

    public static void refresh() {
        //Needs implementation
        Logger.log("Refreshed\n");
    }
}