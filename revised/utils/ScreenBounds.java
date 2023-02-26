package utils;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class ScreenBounds {
    private static Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

    public static int getWidth() {
        return (int) screenBounds.getWidth();
    }

    public static int getHeight() {
        return (int) screenBounds.getHeight();
    }
}
