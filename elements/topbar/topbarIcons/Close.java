package elements.topbar.topbarIcons;

import elements.resources.Resources;
import javafx.scene.layout.StackPane;
import utils.Logger;

public class Close {
    private static StackPane close = null;
    private Close() {};

    public static StackPane getInstance() {
        if (close == null) {
            close = new StackPane(Resources.getButtonTopbar(), Resources.getIconClose());
            close.setOnMouseClicked(e -> {
                Logger.log("Exit program");
                System.exit(0);
            });

            //set stylesheet & class for hover
            return close;
        }

        return close;
    }
}
