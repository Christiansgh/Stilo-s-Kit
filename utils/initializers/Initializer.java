package utils.initializers;

import elements.plugins.logger.Logger;
import elements.regions.sidebar.Sidebar;
import elements.regions.topbar.Topbar;
import elements.resources.Resources;
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
        // create stage/window
        stage = new Stage(StageStyle.UNDECORATED);

        // set the app name
        stage.setTitle("Stilo's Kit");

        stage.getIcons().add(Resources.getLogoApplication(20, 20));

        PluginsInitializer.initialize();

        // run initialization
        AnchorPane root = new AnchorPane(Sidebar.getInstanceSidebar(), Topbar.getInstance(), Logger.getInstanceWindow());

        //Circle toggleLogWindow = CircleFactory.createCircle(circleTypeEnum.btnTopbar);
        //LogWindow.toggleLogWindow(); //set invisible
        //toggleLogWindow.setOnMouseClicked(e -> LogWindow.toggleLogWindow());
        //SidebarIcons.addSidebarIcon(toggleLogWindow);

        AnchorPane.setTopAnchor(Logger.getInstanceWindow(), 23.0);
        
        // execute code HERE

        // makes it so you don't tab out when clicking, acting like an overlay.
        stage.setAlwaysOnTop(true);

        // make scene. Set nonsidebar content as invisible.
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);

        stage.setScene(scene);
        stage.show();
    }
}
