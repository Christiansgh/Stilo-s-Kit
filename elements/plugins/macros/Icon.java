package elements.plugins.macros;

import elements.resources.Resources;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;

public class Icon {
    private SVGPath innerIcon;
    private StackPane icon;
    private Rectangle frame;

    public enum Type {
        ACTIVATION,
        EMPTY
    }

    public Icon(Type type) {
        this();
        String activation = "#5ea1c6";
        String empty = "#E6CA83";
        switch (type) {
            case ACTIVATION:
                frame.setStroke(Color.web(activation));
                innerIcon.setFill(Color.web(activation));
                break;

            case EMPTY:
                frame.setStroke(Color.web(empty));
                innerIcon.setFill(Color.web(empty));
                break;

            default:
                break;
        }
    }

    private Icon() {
        frame = new Rectangle(40, 40, Color.TRANSPARENT);
        frame.setStrokeWidth(2);
        frame.setStroke(Color.web("#E6CA83"));
        frame.setArcHeight(25);
        frame.setArcWidth(25);
        innerIcon = Resources.getIconClose();
        innerIcon.setFill(Color.web("#E6CA83"));
        icon = new StackPane(frame, innerIcon);
    }

    public StackPane getIcon() {
        return icon;
    }
}
