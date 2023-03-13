package elements.general;

import java.util.ArrayList;

import elements.plugins.macros.Macro;
import elements.resources.factories.RectangleFactory;
import elements.resources.factories.RectangleFactory.rectangles;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class PluginWindow {
    private static ArrayList <PluginWindow> pluginWindowsList = new ArrayList<PluginWindow>();
    private StackPane window;
    private VBox rows;

    public PluginWindow() {
        window = new StackPane();
        rows = new VBox();
        rows.setPadding(new Insets(23, 10, 10, 10));
        rows.getStylesheets().addAll("elements/resources/css/sidebar.css");
        rows.setSpacing(20);
        rows.setAlignment(Pos.TOP_CENTER);
        window.setPrefWidth(450);
        pluginWindowsList.add(this);
    }

    public void addRow(Pane row) {
        rows.getChildren().add(row);
    }

    public static void hideWindows() {
        for (PluginWindow pluginWindow : pluginWindowsList) {
            pluginWindow.window.setVisible(false);
        }
    }

    public static StackPane getWeakAurasPluginWindow() {
        PluginWindow weakAurasPluginWindow = new PluginWindow();

        //Add rows and content
        Label title = new Label("WEAK AURAS");
        title.getStyleClass().add("title");
        HBox titleRow = new HBox(title);
        titleRow.setAlignment(Pos.TOP_CENTER);
        weakAurasPluginWindow.addRow(titleRow); 
    
        HBox rowOne = new HBox();
        ToggleSlider isActiveToggleSlider = new ToggleSlider(rowOne, "Active");
        weakAurasPluginWindow.addRow(rowOne);

        weakAurasPluginWindow.window = new StackPane(RectangleFactory.createRectangle(rectangles.PLUGINWINDOW), weakAurasPluginWindow.rows);
        return weakAurasPluginWindow.window;
    }

    public static StackPane getMacrosPluginWindow() {
        PluginWindow macrosPluginWindow = new PluginWindow();

        //add rows & content
        Label title = new Label("MACROS");
        title.getStyleClass().add("title");
        HBox titleRow = new HBox(title);
        titleRow.setAlignment(Pos.TOP_CENTER);
        macrosPluginWindow.addRow(titleRow); 
    
        HBox rowOne = new HBox();
        ToggleSlider isActiveToggleSlider = new ToggleSlider(rowOne, "Active");
        macrosPluginWindow.addRow(rowOne);

        VBox rowTwo = new VBox();
        rowTwo.setSpacing(40);
        Macro macro = new Macro('e', '0');
        Macro macro2 = new Macro('E', 'o');
        rowTwo.getChildren().addAll(macro.getMacro(), macro2.getMacro());
        macrosPluginWindow.addRow(rowTwo);

        macrosPluginWindow.window = new StackPane(RectangleFactory.createRectangle(rectangles.PLUGINWINDOW), macrosPluginWindow.rows);
        return macrosPluginWindow.window;
    }
}
