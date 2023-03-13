package elements.plugins.macros;

import java.util.ArrayList;

import elements.plugins.macros.Icon.Type;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Macro {
    private Icon addingIcon;
    private int row;
    private int column;
    private GridPane icons;
    private TextField macroName;
    private char key;
    private ArrayList<Icon> output;
    private Rectangle frame;
    private VBox macro;
    private StackPane content;

    public Macro(char activationKey, char emptyIconCharacter) {
        //instantiate variables
        row = 0;
        column = 0;
        key = activationKey;
        output = new ArrayList<Icon>();
        macroName = new TextField("Untitled");

        //build the frame
        frame = new Rectangle(425, 75, Color.TRANSPARENT);
        frame.setStroke(Color.web("#E6CA83"));
        frame.setStrokeWidth(2);
        frame.setArcHeight(50);
        frame.setArcWidth(50);

        //holds the output Icons
        icons = new GridPane(); 
        icons.setPadding(new Insets(15, 10, 10, 15));
        icons.setHgap(10);
        icons.setVgap(10);

        //build Blue Square
        Icon activationIcon = new Icon(Type.ACTIVATION, "#5ea1c6", activationKey);
        output.add(activationIcon);
        icons.add(activationIcon.getIcon(), column, row);

        //build Blue Circle
        addingIcon = new Icon(Type.ADD, "#5ea1c6", emptyIconCharacter);
        icons.add(addingIcon.getIcon(), column + 1, row);

        //build Orange Squares on click
        addingIcon.getIcon().setOnMouseClicked(e -> addIcon(new Icon(Type.EMPTY, "#E6CA83", emptyIconCharacter)));
        column++; //move right so we dont override the Blue Square(activation)

        //Build
        content = new StackPane(frame, icons);
        content.setOnMouseClicked(e -> {
            System.out.print("[");
            for (Icon icon : output) {
            System.out.print(icon.getKey() + ", ");
            }
            System.out.print("] Testing purpose. Remove after.\n");
        });
    }
    
    public VBox getMacro() {
        //Building the macro title
        macroName.backgroundProperty().set(Background.EMPTY);
        macroName.setStyle("-fx-text-fill: WHITE");
        macroName.setFocusTraversable(false);

        macro = new VBox(macroName, content);
        macro.setSpacing(10);
        return macro;
    }

    public void setActivationKey() {
        
    }

    public void addIcon(Icon icon) {
        icons.getChildren().remove(addingIcon.getIcon());
        icons.add(icon.getIcon(), column, row);
        column++;
        if (column % 8 == 0) {
            row++;
            column = 0;
            frame.setHeight(frame.getHeight() + 50);
        }
        
        output.add(icon);
        icons.add(addingIcon.getIcon(), column, row);
    }
}
