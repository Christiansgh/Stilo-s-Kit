package elements.skeleton;

import api.Plugin;
import elements.resources.Resources;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utils.ScreenBounds;

public class Skeleton {
    private static AnchorPane root = null;
    private Skeleton() {};

    public static AnchorPane getInstance() {
        if (root == null) {
            root = new AnchorPane();
            root.setMinWidth(ScreenBounds.getWidth());
            root.setMinHeight(ScreenBounds.getHeight());
            root.getChildren().addAll(Plugin.getPluginsStack(), Plugin.getSettingsStack(), Sidebar.getInstance(), Topbar.getInstance());
            AnchorPane.setLeftAnchor(Plugin.getPluginsStack(), 500.0);
            AnchorPane.setRightAnchor(Plugin.getSettingsStack(), 50.0);
            AnchorPane.setRightAnchor(Sidebar.getInstance(), 0.0);
            AnchorPane.setBottomAnchor(Sidebar.getInstance(), 0.0);
        }
        return root;
    }

    public static void initialize(Stage stage) {
        stage = new Stage(StageStyle.UNDECORATED);

        // set the app name
        stage.setTitle("Stilo's Kit");

        stage.getIcons().add(Resources.getLogoApplication(20, 20));

        stage.setAlwaysOnTop(true);

        // make scene. Set nonsidebar content as invisible.
        Scene scene = new Scene(Skeleton.getInstance());
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);

        stage.setScene(scene);
        stage.show();
    }
} 
