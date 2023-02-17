package elements.topbar.topbarIcons;

import elements.resources.Resources;
import javafx.scene.layout.StackPane;

public class Close {
    private static StackPane close = null;
    private Close() {};

    public static StackPane getInstance() {
        if (close == null) {
            close = new StackPane(Resources.getButtonTopbar(), Resources.getIconClose());
            close.setOnMouseClicked(e -> System.exit(0));

            //set stylesheet & class for hover
            return close;
        }

        return close;
    }
}
