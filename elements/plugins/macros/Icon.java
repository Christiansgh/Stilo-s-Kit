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

    public Icon(Type type, char key, char emptyIconCharacter) {
        this();
        String activation = "#5ea1c6";
        String empty = "#E6CA83";
        switch (type) {
            case ACTIVATION:
                frame.setStroke(Color.web(activation));
                innerIcon.setFill(Color.web(activation));
                getIcon().setOnMouseClicked(e -> {
                    icon.getChildren().remove(innerIcon);
                    Label activationKeyChar = new Label(String.valueOf(key));
                    icon.getChildren().add(activationKeyChar);
                    activationKeyChar.setStyle("-fx-font-weight: 900; \n -fx-text-fill: #F7F7F7;");
                    activationKeyChar.setScaleX(2);
                    activationKeyChar.setScaleY(2);
                });
                break;

            case EMPTY:
                frame.setStroke(Color.web(empty));
                innerIcon.setFill(Color.web(empty));
                getIcon().setOnMouseClicked(e -> {
                    icon.getChildren().remove(innerIcon);
                    Label activationKeyChar = new Label(String.valueOf(emptyIconCharacter));
                    icon.getChildren().add(activationKeyChar);
                    activationKeyChar.setStyle("-fx-font-weight: 900; \n -fx-text-fill: #F7F7F7;");
                    activationKeyChar.setScaleX(2);
                    activationKeyChar.setScaleY(2);
                });
                break;

            case ADD:
                frame.setStroke(Color.TRANSPARENT);
                innerIcon.setFill(Color.web(activation));
                Circle add = new Circle(15, Color.TRANSPARENT);
                add.setStroke(Color.web(activation));
                add.setStrokeWidth(2);
                icon.getChildren().add(add);
                getIcon().setOnMouseClicked(e -> {
                    icon.getChildren().remove(innerIcon);
                    Label activationKeyChar = new Label(String.valueOf(emptyIconCharacter));
                    setKey(emptyIconCharacter);
                    icon.getChildren().add(activationKeyChar);
                    activationKeyChar.setStyle("-fx-font-weight: 900; \n -fx-text-fill: #F7F7F7;");
                    activationKeyChar.setScaleX(2);
                    activationKeyChar.setScaleY(2);
                });
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
        innerIcon.setRotate(0);
        innerIcon.setFill(Color.web("#E6CA83"));
        icon = new StackPane(frame, innerIcon);
    }

    public StackPane getIcon() {
        return icon;
    }

    public void setKey(char key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return String.valueOf(key);
    }
}
