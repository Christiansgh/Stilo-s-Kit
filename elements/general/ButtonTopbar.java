package elements.general;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;

public class ButtonTopbar {
    private StackPane buttonTopbar;

    public ButtonTopbar(SVGPath icon) {
        Circle circle = new Circle(9, Color.web("#E6CA83"));
        buttonTopbar = new StackPane(circle, icon);
    }

    public StackPane getButtonTopbar() {
        return buttonTopbar;
    }
}
