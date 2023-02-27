package utils.event;

import javafx.util.Duration;
import utils.RobotController;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

import java.awt.Rectangle;

public class EventListener {
    private final Duration TICK = Duration.millis(600);
    private int updateTicks;
    private Rectangle screenArea;
    private int x, y, height, width;
    private BufferedImage screenshot;

    public EventListener(int xTopLeft, int yTopLeft, int height, int width) {
        screenArea = new Rectangle(xTopLeft, yTopLeft, width, height);

    }

    public BufferedImage getScreenShot() {
        screenshot = RobotController.getInstance().createScreenCapture(screenArea);
        return screenshot;
    }

    public String getScreenArea() {
        return String.format("Topleft x, y: %d, %d, Width, Height: %d, %d", x, y, width, height);
    }

    public void setScreenArea(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void drawScreenArea() {

    }

    private Mat convertBufferedImageToMat(BufferedImage BI) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(BI, "png", byteArrayOutputStream);
        byteArrayOutputStream.flush();
        return Imgcodecs.imdecode(new MatOfByte(byteArrayOutputStream.toByteArray()), Imgcodecs.IMREAD_ANYCOLOR);
    }
    //Take screenshot -> Robots & based on screenarea.

    //Process the screenshot -> openCV -> imgproc -> matchTemplate.

    //should return a coeff based on how close a match is found -> if the match is over 0.XX then we can reasonably say, that a buff was found.
    //if (coef > X) -> buff.setIsActive(true);
}
