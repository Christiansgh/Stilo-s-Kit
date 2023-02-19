package elements.resources.box;

import elements.fingerprinting.ScreenBounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoxFactory {
    public enum boxTypeEnum {
        boxTooltip,
        boxLogging,
        boxQuestHelper,
        boxOverlay,
        boxMacroOverlay,
        boxSidebar,
        boxTopbar
    }

    public static Rectangle createBox(boxTypeEnum type) {
        switch (type) {
            case boxLogging:
                Rectangle boxLogging = new Rectangle(750, 900, Color.BLACK);
                boxLogging.setOpacity(0.2);
                boxLogging.setStroke(Color.WHITE);
                boxLogging.setStrokeWidth(2);
                return boxLogging;

            case boxSidebar:
                Rectangle boxSidebar = new Rectangle(30, ScreenBounds.getHeight(), Color.web("#000000"));
                boxSidebar.setX(ScreenBounds.getWidth()-30);
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
