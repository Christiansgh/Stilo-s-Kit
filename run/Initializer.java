package run;

import elements.resources.Resources;
import elements.sidebar.Sidebar;
import elements.topbar.Topbar;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/*
 * Initializes / updates the state of the app.
 */

public class Initializer {
    public static void initializeStage(Stage stage) {
        //create stage/window
        stage = new Stage(StageStyle.UNDECORATED);
        
        //set the app name
        stage.setTitle("Stilo's Kit");

        stage.getIcons().add(Resources.getLogoApplication(20, 20));
        
        //run initialization
        AnchorPane root = new AnchorPane(Sidebar.getInstance(), Topbar.getInstance());

        //
        //
        //execute code HERE
        //
        //
        
        //makes it so you don't tab out when clicking, acting like an overlay.
        stage.setAlwaysOnTop(true);

        //make scene. Set nonsidebar content as invisible.
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);

        stage.setScene(scene);
        stage.show();
    }
}
