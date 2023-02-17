package elements.topbar.topbarIcons;

import elements.resources.Resources;
import javafx.scene.layout.StackPane;

public class Refresh {
    private static StackPane refresh = null;
    private Refresh() {};

    public static StackPane getInstance() {
        if (refresh == null) {
            StackPane refresh = new StackPane(Resources.getButtonTopbar(), Resources.getIconRefresh());
            refresh.setOnMouseClicked(e -> System.out.println("Implement refresh state method"));
            return refresh;
        }

        return refresh;
    }
}