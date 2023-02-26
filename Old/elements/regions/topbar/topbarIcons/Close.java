package elements.regions.topbar.topbarIcons;

import elements.plugins.logger.Logger;
import elements.resources.Resources;
import elements.resources.factories.CircleFactory;
import elements.resources.factories.CircleFactory.circleTypeEnum;
import javafx.scene.layout.StackPane;

public class Close {
    private static StackPane close = null;
    private Close() {};

    public static StackPane getInstance() {
        if (close == null) {
            close = new StackPane(CircleFactory.createCircle(circleTypeEnum.btnTopbar), Resources.getIconClose());
            close.setOnMouseClicked(e -> {
                Logger.getInstanceLogger().log("Exit program");
                System.exit(0);
            });

            //set stylesheet & class for hover
            return close;
        }

        return close;
    }

    public void initialize() {
        getInstance().setOnMouseClicked(e -> {
            Logger.getInstanceLogger().log("Exit program");
            System.exit(0);
        });
    }
}
