package elements.topbar;

import elements.fingerprinting.ScreenBounds;
import elements.resources.Resources;
import elements.topbar.topbarIcons.Close;
import elements.topbar.topbarIcons.Refresh;
import elements.topbar.topbarIcons.ToggleSidebar;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Topbar {
    private static AnchorPane topbar = null;
    private Topbar() {};

    public static AnchorPane getInstance() {
        if (topbar == null) {
            Rectangle topbarBackground = new Rectangle(ScreenBounds.getWidth(), 23, Color.web("#000000"));
            topbarBackground.setY(0);

            ImageView logoView = new ImageView(Resources.getLogo(20, 20));

            Label labelTopbar = new Label("STILOS KIT");
            labelTopbar.getStylesheets().add("elements/css/base.css");
            labelTopbar.getStyleClass().add("topbarContent");

            //add icons to a HBox
            HBox topbarIcons = new HBox(Refresh.getInstance(), ToggleSidebar.getInstance(), Close.getInstance());
            topbarIcons.setSpacing(20);
            topbar = new AnchorPane(topbarBackground, logoView, labelTopbar, topbarIcons);
        
            AnchorPane.setLeftAnchor(labelTopbar, 30.0);
            AnchorPane.setTopAnchor(labelTopbar, 2.0);
            AnchorPane.setRightAnchor(topbarIcons, 10.0);
            return topbar;
        }

        return topbar;
    }
}
