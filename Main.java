import javafx.application.Application;
import javafx.stage.Stage;
import run.Initializer;

/*
 * TODO:
 * For the Color.web("String color"):
 * - When implementing colorsettings, make it into a string, that fetches from the settings document.
 * - Maybe even a class that contains the settings w/ public getString(settings color)
 * - i.e. String panelcolor ="#F7F7F7"
 *      - Color.web(panelcolor)
 * 
 * Add hover pseudostates to the 3 top right buttons
 * - Thinking lighter gray circle and maybe turning the buttons lightblue if it looks ok
 * 
 * Move the Circle & SVGpaths to Resources.
 * 
 * For search:
 * Search function (Not capital sensitive)
 * Textfield for searching.
 * Listview or tableview
 * Hboxes {label(pluginName), stackpane(svgpath cog & circle - settings) icon/?svgpath?/?radiohead? toggleactive}
 * 
 * For macros:
 * List of each macro.
 * - Name
 * - A button showing the state (active inactive)
 * - A cog for editing
 * - A loop for viewing the graphical layout.
 * 
 * Gridpane of stackpanes (ability image & keybound)
 * arrows between each box to symbolize order keys are sent in
 * option to add wait in between each key
 * - symbolised with a label under it representing ticks.
 * + icon to add ability
 * 
 * "Modes"
 * - activation key
 * - mode and what keybinds changes into what
 * - customization for mode & what is displayed
 */

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Application.setUserAgentStylesheet(STYLESHEET_CASPIAN); //change this. its wrong, but it fixed the control whitebackground issue.
        
        //create the window
        Initializer.initializeStage(stage);

        //set initial dimensions
        stage.setMaximized(true);

        
    }
}
