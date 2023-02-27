package run;

import javafx.application.Application;
import javafx.stage.Stage;
import elements.skeleton.Skeleton;

/*
 * What do we seek:
 * - Build the skeleton.
 *      - Singleton vs. Reuseable elements.
 *      - Sidebar & topbar => singleton.
 *      - 
 * - Make good APIs for implementing plugins
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //sets the background of root as transparrent.
        Application.setUserAgentStylesheet(STYLESHEET_CASPIAN); //change this. its wrong, but it fixed the control whitebackground issue.

        Skeleton.initialize(stage);
        //run plugin initializer
        //run settings initializer        

        //create the window

        //set initial dimensions
        stage.setMaximized(true);
    }
    
}
