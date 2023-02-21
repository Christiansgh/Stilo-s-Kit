package elements.plugins.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

import api.Plugin;
import elements.regions.sidebar.Sidebar;
import elements.resources.factories.BoxFactory;
import elements.resources.factories.CircleFactory;
import elements.resources.factories.BoxFactory.boxTypeEnum;
import elements.resources.factories.CircleFactory.circleTypeEnum;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;



public class Logger extends Plugin {
    private boolean isVisible = false;
    private boolean isActive = false;
    private static TextFlow logs = null;
    private static Logger logger = null;
    private static StackPane window = null;

    private Logger(boolean isVisible, boolean isActive, Node pluginIcon, Node pluginWindow) {
        super(isVisible, isActive, pluginIcon, pluginWindow);
    }

    public static TextFlow getInstanceLogs() {
        if (logs == null) {
            logs = new TextFlow();
            return logs;
        }

        return logs;
    }

    public static Logger getInstanceLogger() {
        if (logger == null) {
            StackPane loggerIcon = new StackPane(CircleFactory.createCircle(circleTypeEnum.btnPlaceHolder), CircleFactory.createCircle(circleTypeEnum.btnTopbar));
            logger = new Logger(false, false, loggerIcon, getInstanceWindow());
            return logger;
        }
        
        return logger;
    }

    public static StackPane getInstanceWindow() {
        if (window == null) {
            window = new StackPane(BoxFactory.createBox(boxTypeEnum.boxLogging), getInstanceLogs());
            return window;
        }

        return window;
    }

    public void log(String message) {
        Text text = new Text(String.format("%s | %s", getTimestamp(), message));
        text.setFill(Color.WHITE);
        text.setFont(Font.font("Helvetica", FontPosture.ITALIC, 25));
        addLog(text);
    }

    //service method for adding a log
    private void addLog(Text text) {
        getInstanceLogs().getChildren().add(text);
    }

    //service method for getting the timestamp
    private String getTimestamp() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
        String timestamp = simpleDateFormat.format(date);
        return timestamp;
    }

    @Override
    public void toggleVisible() {
        isVisible = !isVisible;
        getInstanceWindow().setVisible(isVisible);

        if (isVisible) {
            getInstanceLogger().log("Showed the log window\n");
        }

        else {
            getInstanceLogger().log("Hid the log window\n");
        }
    }

    @Override
    public void toggleActive() {
        // TODO Auto-generated method stub
        System.out.println("clicked the logs box");
    }

    @Override
    public void initialize() {
        pluginWindow.setVisible(isActive);        
        Sidebar.addPlugin(pluginIcon, pluginWindow, getInstanceLogger());
    }
}