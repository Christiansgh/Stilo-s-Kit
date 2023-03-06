package elements.general;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class ToggleSlider extends StackPane {
    private boolean isActive;
    private Rectangle background;
    private StackPane toggleSlider;

    public ToggleSlider(Pane parent, String setting) {
        isActive = false;
        background = new Rectangle(250, 100, Color.web("#b2b2b2"));
        background.setStroke(Color.web("#000000"));
        background.setStrokeWidth(3);
        Circle button = new Circle(50, Color.web("#F7F7F7"));
        button.setStroke(Color.web("#000000"));
        button.setStrokeWidth(1);
        toggleSlider = new StackPane(background, button);
        toggleSlider.setPrefSize(250, 250);
        Label settingText = new Label(setting);
        settingText.setPrefSize(250, 250);
        VBox toggleSliderVBox = new VBox(settingText, toggleSlider);
        toggleSliderVBox.setPrefSize(250, 250);
        toggleSliderVBox.setSpacing(5.0);
        settingText.setOnMouseClicked(e -> System.out.println("Test"));
        settingText.getStylesheets().add("elements/resources/css/sidebar.css");
        settingText.getStyleClass().addAll("title");
        parent.getChildren().add(toggleSliderVBox);
    }   

    public void toggle() {
        isActive = !isActive;

        if(isActive) {
            background.setFill(Color.web("#E6CA83"));
            //move the circle
        }

        else {
            background.setFill(Color.web("#b2b2b2"));
            //move the circle
        }
    }

    public boolean getIsActive() {
        return isActive;
    }
}
