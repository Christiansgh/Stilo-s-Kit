package elements.plugins.macros;

import java.util.ArrayList;

import elements.plugins.macros.Icon.Type;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Macro {
    private KeyCode activationKey;
    private ArrayList<StackPane> output;
    private Rectangle frame;
    private StackPane macro;

    public Macro() {
        output = new ArrayList<StackPane>();
        frame = new Rectangle(425, 75, Color.TRANSPARENT);
        frame.setStroke(Color.web("#E6CA83"));
        frame.setStrokeWidth(2);
        frame.setArcHeight(50);
        frame.setArcWidth(50);
        Icon test = new Icon(Type.ACTIVATION); //add these to the stackpane.
        macro = new StackPane(frame, test.getIcon());
    }
    
    public StackPane getMacro() {
        return macro;
    }

    public void setActivationKey() {

    }
}
