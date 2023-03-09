package elements.plugins.macros;

import java.util.ArrayList;

import elements.plugins.macros.Icon.Type;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.Background;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Macro {
    private Icon addIcon;
    private int row;
    private int column;
    private GridPane icons;
    private TextField macroName;
    private KeyCode activationKey;
    private char key;
    private ArrayList<Icon> output;
    private Rectangle frame;
    private VBox macro;
    private StackPane content;

    public Macro(char activationKey, char emptyIconCharacter) {
        row = 0;
        column = 0;
        key = activationKey;
        output = new ArrayList<Icon>();
        addIcon = new Icon(Type.ADD, activationKey, emptyIconCharacter);
        frame = new Rectangle(425, 75, Color.TRANSPARENT);
        macroName = new TextField("Untitled");
        macroName.backgroundProperty().set(Background.EMPTY);
        macroName.setStyle("-fx-text-fill: WHITE");
        macroName.setFocusTraversable(false);
        frame.setStroke(Color.web("#E6CA83"));
        frame.setStrokeWidth(2);
        frame.setArcHeight(50);
        frame.setArcWidth(50);
        Icon test = new Icon(Type.ACTIVATION, activationKey, emptyIconCharacter); //add these to the stackpane.
        test.setKey(activationKey);
        icons = new GridPane();
        icons.add(test.getIcon(), column, row);
        icons.add(addIcon.getIcon(), column + 1, row);
        column++;
        addIcon.getIcon().setOnMouseClicked(e -> addIcon(new Icon(Type.EMPTY, activationKey, emptyIconCharacter)));
        icons.setPadding(new Insets(15, 10, 10, 15));
        icons.setHgap(10);
        icons.setVgap(10);
        content = new StackPane(frame, icons);
        content.setOnMouseClicked(e -> System.out.println(output));
    }
    
    public VBox getMacro() {
        macro = new VBox(macroName, content);
        macro.setSpacing(10);
        return macro;
    }

    public void setActivationKey() {
        
    }

    public void addIcon(Icon icon) {
        icons.getChildren().remove(addIcon.getIcon());
        icons.add(icon.getIcon(), column, row);
        column++;
        if (column % 8 == 0) {
            row++;
            column = 0;
            frame.setHeight(frame.getHeight() + 50);
        }
        
        output.add(icon);
        icons.add(addIcon.getIcon(), column, row);
    }
}
