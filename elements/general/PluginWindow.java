package elements.general;

import elements.resources.factories.RectangleFactory;
import elements.resources.factories.RectangleFactory.rectangles;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class PluginWindow {
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
    }

    public void addRow(Pane row) {
        rows.getChildren().add(row);
    }

    public static StackPane getWeakAurasPluginWindow() {
        PluginWindow weakAurasPluginWindow = new PluginWindow();

        //Add rows and content
        Label title = new Label("WEAK AURAS");
        title.getStyleClass().add("title");
        HBox titleRow = new HBox(title);
        titleRow.setAlignment(Pos.TOP_CENTER);
        weakAurasPluginWindow.addRow(titleRow);
    
        BorderPane rowOne = new BorderPane();
        ToggleSlider isActiveToggleSlider = new ToggleSlider(rowOne, "II");
        weakAurasPluginWindow.addRow(rowOne);

        weakAurasPluginWindow.window = new StackPane(RectangleFactory.createRectangle(rectangles.PLUGINWINDOW), weakAurasPluginWindow.rows);
        return weakAurasPluginWindow.window;
    }
}
