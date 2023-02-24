package elements.resources.factories;

import elements.fingerprinting.ScreenBounds;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoxFactory {
    public enum boxTypeEnum {
        boxSettingsWindow,
        boxTooltip,
        boxLogging,
        boxQuestHelper,
        boxOverlay,
        boxMacroOverlay,
        boxSidebar,
        boxTopbar
    }

    public static Node createBox(boxTypeEnum type) {
        switch (type) {
            case boxSettingsWindow:
                Rectangle rect = new Rectangle(400, ScreenBounds.getHeight(), Color.web("#111111"));
                rect.setStroke(Color.GREY);
                rect.setStrokeWidth(2);
                return rect;
            
            case boxLogging:
                Rectangle boxLogging = new Rectangle(750, 900, Color.BLACK);
                boxLogging.setOpacity(0.7);
                boxLogging.setStroke(Color.WHITE);
                boxLogging.setStrokeWidth(2);
                return boxLogging;

            case boxSidebar:
                Rectangle boxSidebar = new Rectangle(45, ScreenBounds.getHeight(), Color.web("#000000"));
                boxSidebar.setX(ScreenBounds.getWidth()-45);
                return boxSidebar;

            case boxTopbar:
                Rectangle boxTopbar = new Rectangle(ScreenBounds.getWidth(), 23, Color.web("#000000"));
                boxTopbar.setY(0);
                return boxTopbar;
        
            default:
                System.out.println("ERROR: Boxtype not found");
                Rectangle rectangle = new Rectangle();
                return rectangle;
        }
    }
}
