package elements.general;

import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class ToggleSlider extends StackPane {
    private boolean isActive;
    private Rectangle background;
    private StackPane toggleSlider;
    private TranslateTransition toggleButton;

    public ToggleSlider(Pane parent, String setting) {
        isActive = false;

        background = new Rectangle(40, 20, Color.web("#b2b2b2"));
        background.setStroke(Color.web("#000000"));
        background.setStrokeWidth(1);
        background.setArcHeight(20);
        background.setArcWidth(20);

        Circle button = new Circle(10, Color.web("#F7F7F7"));
        button.setStroke(Color.web("#000000"));
        button.setStrokeWidth(1);
        button.setCenterX(10);
        button.setCenterY(10);

        //Animation
        toggleButton = new TranslateTransition();
        toggleButton.setDuration(Duration.millis(100));
        toggleButton.setNode(button);

        toggleSlider = new StackPane(background, button);
        toggleSlider.setAlignment(Pos.CENTER_LEFT);

        Label settingText = new Label(setting);
        VBox toggleSliderVBox = new VBox(settingText, toggleSlider);
        toggleSliderVBox.setSpacing(5.0);

        toggleSlider.setOnMouseClicked(e -> this.toggle());
        settingText.getStylesheets().add("elements/resources/css/sidebar.css");
        settingText.getStyleClass().addAll("sidebarLabel");
        parent.getChildren().add(toggleSliderVBox);
    }   

    public void toggle() {
        isActive = !isActive;

        if(isActive) {
            background.setFill(Color.web("#E6CA83"));
            toggleButton.setByX(20);
            toggleButton.play();
        }

        else {
            background.setFill(Color.web("#b2b2b2"));
            toggleButton.setByX(-20);
            toggleButton.play();
        }
    }

    public boolean getIsActive() {
        return isActive;
    }
}
