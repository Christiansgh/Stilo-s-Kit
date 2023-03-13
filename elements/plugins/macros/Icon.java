package elements.plugins.macros;

import java.io.IOError;

import elements.general.ButtonTopbar;
import elements.resources.Resources;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Skin;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;

public class Icon {
    private SVGPath innerIcon;
    private AnchorPane iconWindow;
    private Rectangle frame;
    private StackPane icon;
    private StackPane settings;
    private Image image;
    private char key;
    private boolean isVisibleSettings;

    public enum Type {
        ACTIVATION,
        ADD,
        EMPTY
    }

    public Icon(Type type, String frameColor, char key) {
        this.key = key;
        
        //Build the settings window
        String[] images = {"default", "test", "test2"};
        ChoiceBox<String> imageChoice = new ChoiceBox<String>();
        imageChoice.getItems().addAll(images);
        imageChoice.setValue("default");
        imageChoice.setFocusTraversable(false);
        imageChoice.setBackground(Background.EMPTY);
        imageChoice.setBorder(Border.stroke(Color.web(frameColor)));
        imageChoice.getStylesheets().add("elements/resources/css/macros.css");

        TextField keyField = new TextField();
        keyField.setPromptText("Key");
        keyField.setFocusTraversable(false);
        keyField.setBackground(Background.EMPTY);
        keyField.setBorder(Border.stroke(Color.web(frameColor)));
        keyField.setStyle("-fx-text-fill: " + frameColor + "; \n -fx-font-weight: 900;");

        ButtonTopbar accept = new ButtonTopbar(Resources.getIconClose());
        ButtonTopbar decline = new ButtonTopbar(Resources.getIconClose());
        HBox choice = new HBox(20);
        choice.getChildren().addAll(accept.getButtonTopbar(), decline.getButtonTopbar());
        Rectangle background = new Rectangle(70, 90, Color.web("#333333"));
        background.setStroke(Color.web("#F7F7F7"));
        background.setStrokeWidth(2);
        background.setArcWidth(20);
        background.setArcHeight(20);
        background.setOpacity(0.8);

        VBox settingsContent = new VBox(imageChoice, keyField, choice);
        settingsContent.setSpacing(5);
        settingsContent.setMaxWidth(50);

        settings = new StackPane(background, settingsContent);
        //Hide settings on initialization
        isVisibleSettings = true;
        settings.toFront();
        toggleVisible();
        decline.getButtonTopbar().setOnMouseClicked(e -> toggleVisible());

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
        iconWindow = new AnchorPane(icon, settings);
        settingsContent.setMaxSize(40, 40);
        AnchorPane.setRightAnchor(icon, 0.0);
        AnchorPane.setTopAnchor(icon, 0.0);
        AnchorPane.setLeftAnchor(settings, -50.0);
        AnchorPane.setBottomAnchor(settings, -70.0);

        switch (type) {
            case ACTIVATION:
                setListener(this, key, "#F7F7F7");
                settingsContent.getChildren().remove(imageChoice);
                background.setHeight(60);
                AnchorPane.setBottomAnchor(settings, -40.0);
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
        MacroWindowsMediator.getInstance().addWindow(this);
    }

    private StackPane getInnerIcon() {
        return icon;
    }
    
    public AnchorPane getIcon() {
        return iconWindow;
    }

    public void setKey(char key) {
        this.key = key;
    }

    public void setVisible(boolean setting) {
        isVisibleSettings = setting;
    }

    public StackPane getSettings() {
        return settings;
    }

    public char getKey() {
        return key;
    }

    private void setListener(Icon icon, char character, String colorHex) {
        icon.getInnerIcon().setOnMouseClicked(e -> {
            icon.getInnerIcon().getChildren().remove(innerIcon);
            Label activationKeyChar = new Label(String.valueOf(character));
            icon.getInnerIcon().getChildren().add(activationKeyChar);
            activationKeyChar.setStyle("-fx-font-weight: 900; \n -fx-text-fill: " + colorHex + ";");
            activationKeyChar.setScaleX(2);
            activationKeyChar.setScaleY(2);
            MacroWindowsMediator.getInstance().notify(this);
            toggleVisible();
        });
    }

    //TODO:
    //SET ON MOUSE CLICKS TOGGLE
    //IMPLEMENT ACCEPT / DECLINE
    //IMPLEMENT CHECKMARK NOT 2x CROSS
    //IMPLEMENT WAY TO CHANGE THE ICON BASED ON DROPDOWN
    // - setIcon()

    private void toggleVisible() {
        isVisibleSettings = !isVisibleSettings;
        settings.setVisible(isVisibleSettings);
    }

    @Override
    public String toString() {
        return String.valueOf(key);
    }
}
