package utils.misc;

import java.awt.AWTException;
import java.awt.Robot;

public class RobotController {
    private static Robot robot;
    private RobotController() {};

    public static Robot getInstance() {
        if (robot == null) {
            try {
                robot = new Robot();
                return robot;
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }

        return robot;
    }
}
