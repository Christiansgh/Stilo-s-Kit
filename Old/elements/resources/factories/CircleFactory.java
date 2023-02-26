package elements.resources.factories;

import elements.plugins.logger.Logger;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleFactory {
    public enum circleTypeEnum {
        btnPlaceHolder,
        btnTopbar
    }

    public static Circle createCircle(circleTypeEnum type) {
        switch (type) {
            case btnPlaceHolder:
                Circle btnPlaceHolder = new Circle(15, Color.web("0fb6e0"));
                return btnPlaceHolder;

            case btnTopbar:
                Circle btnTopbar = new Circle(9, Color.web("#E6CA83"));
                return btnTopbar;
        
            default:
                Logger.getInstanceLogger().log("Circle type not found.");
                Circle circle = new Circle();
                return circle;
        }
    }
}
