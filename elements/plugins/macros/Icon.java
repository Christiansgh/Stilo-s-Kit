package elements.plugins.macros;

import elements.resources.Resources;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;

public class Icon {
    private SVGPath innerIcon;
    private StackPane icon;
    private Rectangle frame;
    private char key;

    public enum Type {
        ACTIVATION,
        ADD,
        EMPTY
    }

    public Icon(Type type, String frameColor, char key) {
        //Build the frame
        frame = new Rectangle(40, 40, Color.TRANSPARENT);
        frame.setStrokeWidth(2);
        frame.setStroke(Color.web(frameColor));
        frame.setArcHeight(25);
        frame.setArcWidth(25);

        //Build the inner icon
        innerIcon = Resources.getIconClose();
        innerIcon.setRotate(0);
        innerIcon.setFill(Color.web(frameColor));

        //Build then configure the icon
        icon = new StackPane(frame, innerIcon);
        switch (type) {
            case ACTIVATION:
                setListener(this, key, "#F7F7F7");
                break;
            
            case ADD:
                frame.setStrokeWidth(0);
                Circle addFrame = new Circle(15, Color.TRANSPARENT);
                addFrame.setStroke(Color.web(frameColor));
                addFrame.setStrokeWidth(2);
                icon.getChildren().addAll(addFrame);
                break;

            case EMPTY:
                setListener(this, key, frameColor);
                break;

            default:
                break;
        }
    }
    
    public StackPane getIcon() {
        return icon;
    }

    public void setKey(char key) {
        this.key = key;
    }

    private void setListener(Icon icon, char character, String colorHex) {
        icon.getIcon().setOnMouseClicked(e -> {
            icon.getIcon().getChildren().remove(innerIcon);
            Label activationKeyChar = new Label(String.valueOf(character));
            icon.getIcon().getChildren().add(activationKeyChar);
            activationKeyChar.setStyle("-fx-font-weight: 900; \n -fx-text-fill: " + colorHex + ";");
            activationKeyChar.setScaleX(2);
            activationKeyChar.setScaleY(2);
        });
    }

    @Override
    public String toString() {
        return String.valueOf(key);
    }
}
