package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Logger {
    private static TextFlow logger = null;
    private Logger() {};

    public static TextFlow getInstance() {
        if (logger == null) {
            logger = new TextFlow();
            return logger;
        }

        return logger;
    }

    public static void log(String message) {
        Text text = new Text(String.format("%s | %s", getTimestamp(), message));
        text.setFill(Color.WHITE);
        text.setFont(Font.font("Helvetica", FontPosture.ITALIC, 25));
        addLog(text);
    }

    //service method for adding a log
    private static void addLog(Text text) {
        getInstance().getChildren().add(text);
    }

    //service method for getting the timestamp
    private static String getTimestamp() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
        String timestamp = simpleDateFormat.format(date);
        return timestamp;
    }
}