package elements.plugins;

import java.text.SimpleDateFormat;
import java.util.Date;

import api.Plugin;
import elements.regions.sidebar.Sidebar;
import elements.regions.windows.LogWindow;
import elements.resources.factories.CircleFactory;
import elements.resources.factories.CircleFactory.circleTypeEnum;
import javafx.scene.Node;
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
            logger = new Logger(true, false, CircleFactory.createCircle(circleTypeEnum.btnPlaceHolder), LogWindow.getInstance());
            return logger;
        }
        
        return logger;
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
        LogWindow.getInstance().setVisible(isVisible);

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
    public boolean isActive() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Node getPluginIcon() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPluginIcon(Node newIcon) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void initialize() {
        Sidebar.addPlugin(pluginIcon, pluginWindow, getInstanceLogger());
        //create a circle -> CircleFactory.
        //setOnMouseClicked(e -> ToggleWindow)
        //add the circle to the sidebar
        //set the window to invisible.
    }
}