package elements.regions.topbar;

import elements.regions.topbar.topbarIcons.Close;
import elements.regions.topbar.topbarIcons.Refresh;
import elements.regions.topbar.topbarIcons.ToggleSidebar;
import elements.resources.Resources;
import elements.resources.factories.BoxFactory;
import elements.resources.factories.BoxFactory.boxTypeEnum;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class Topbar {
    private static AnchorPane topbar = null;
    private Topbar() {};

    public static AnchorPane getInstance() {
        if (topbar == null) {

            ImageView logoView = new ImageView(Resources.getLogo(20, 20));

            Label labelTopbar = new Label("STILOS KIT");
            labelTopbar.getStylesheets().add("elements/css/base.css");
            labelTopbar.getStyleClass().add("topbarContent");

            //add icons to a HBox
            HBox topbarIcons = new HBox(Refresh.getInstance(), ToggleSidebar.getInstance(), Close.getInstance());
            topbarIcons.setSpacing(20);
            topbar = new AnchorPane(BoxFactory.createBox(boxTypeEnum.boxTopbar), logoView, labelTopbar, topbarIcons);
        
            AnchorPane.setLeftAnchor(labelTopbar, 30.0);
            AnchorPane.setTopAnchor(labelTopbar, 2.0);
            AnchorPane.setRightAnchor(topbarIcons, 10.0);
            return topbar;
        }

        return topbar;
    }
}
