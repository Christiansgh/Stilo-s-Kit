package run;

import javafx.application.Application;
import javafx.stage.Stage;
import utils.initializers.Initializer;

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
 * 
 * Logging: 
 * Add all the logs to an array.
 * When executing the Open window method
 *  - Clear the window.
 *  - Populate it with the array of logs (text).
 * 
 * Clean up:
 * Make toggleable windows inherit from the abstract class "toggleable"
 * - Needs to extend, since we need to force an attribute containing state.
 * - Needs to implement toggle() to toggle the state, and isToggled(), as a getter method to get the state.
 * - Phase out Toggler.java
 * 
 * Make plugin interface:
 * - Implement initialize(), adding the icon to the sidebar, setting the plugin icon.
 * - Implement another toggle isActive().
 * - Implement a method that holds a window (stackpane populated with children)
 * 
 * Clean the plugin abstract class:
 * - look at the class & Logger. Logger has some methods which didn't need implementation.
 *      - Do we really need these? If not - then cut them.
 * 
 * Move:
 * - In weakAuras: The activate(String soundName),
 *      - String sound name should be a parameter in the constructor, og made as a set method.
 *      - It should not be a parameter in the activate(), since not all weakauras need a sound.
 * 
 * Hide windows:
 * Find a way in Sidebar.addPlugin() to set the plugin window invisible on initalization.
 * 
 * Set the main window to multiple GridPanes. This way we can display windows in the grid.
 * - 1 for Big windows.
 * - 1 for smaller icons.
 * 
 * Clean up layout:
 * Make the setting windows children of the sidebar instead. This will assure, that when the sidebar is toggled,
 * we will hide the active settings window as well.
 * 
 * Detection of buffs:
 * OpenCV:
 * cv(2?).matchTemplate(needleImg);
 * max_val(double returned as match confidence), max_loc( x , y)
 * .rectangle(topleft corner height width(rgb color, line thickness)) - draws rectangle around the template
 * 
 * Maybe the robots api can work with createScrenCapture()?
 * - Creates a buffered image, maybe I can use that with matchTemplate()?
 *      - Call it every tick?
 * BufferedImage.isOnScreen()?
 * 
 * https://www.linkedin.com/pulse/opencv-java-yolo-object-detection-images-svetozar-radoj%C4%8Din?trk=pulse-article_more-articles_related-content-card
 * https://sikulix.github.io/docs/
 * https://docs.opencv.org/2.4/doc/tutorials/imgproc/histograms/template_matching/template_matching.html
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
