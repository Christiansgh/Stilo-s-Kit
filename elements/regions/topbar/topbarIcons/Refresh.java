package elements.regions.topbar.topbarIcons;

import elements.plugins.Logger;
import elements.resources.Resources;
import elements.resources.factories.CircleFactory;
import elements.resources.factories.CircleFactory.circleTypeEnum;
import javafx.scene.layout.StackPane;

public class Refresh {
    private static StackPane refresh = null;
    private Refresh() {};

    public static StackPane getInstance() {
        if (refresh == null) {
            StackPane refresh = new StackPane(CircleFactory.createCircle(circleTypeEnum.btnTopbar), Resources.getIconRefresh());
            refresh.setOnMouseClicked(e -> refresh());
            return refresh;
        }

        return refresh;
    }

    public static void refresh() {
        //Needs implementation
        Logger.getInstanceLogger().log("Refreshed\n");
    }
}