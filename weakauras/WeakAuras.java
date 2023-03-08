package weakauras;
/*package weakauras;

import javafx.animation.ScaleTransition;
import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import utils.SoundPlayer;

public abstract class WeakAuras {
    private static StackPane auraImages = null;
    private Node image;
    private int endScaleSize;
    private double startOpacity;
    private double endOpacity;
    private int transitionTimeMillis;

    public WeakAuras(Node image, int endScaleSize, double startOpacity, double endOpacity, int transitionTimeMillis) {
        this.image = image;
        this.endScaleSize = endScaleSize;
        this.startOpacity = startOpacity;
        this.endOpacity = endOpacity;
        this.transitionTimeMillis = transitionTimeMillis;
    }

    public static StackPane getAuraImages() {
        if (auraImages == null) {
            auraImages = new StackPane();
            return auraImages;
        }

        return auraImages;
    }

    public void initialize() {
        getAuraImages().getChildren().addAll(image);
        image.setVisible(false);
    }

    public void activate(String soundName) {
        SoundPlayer.playSound(soundName);
        image.setVisible(true);
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(transitionTimeMillis), image);
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(transitionTimeMillis), image);
        scaleTransition.setToX(endScaleSize);
        scaleTransition.setToY(endScaleSize);
        fadeTransition.setFromValue(startOpacity);
        fadeTransition.setToValue(endOpacity);

        scaleTransition.setAutoReverse(true);
        fadeTransition.setAutoReverse(true);
        scaleTransition.setCycleCount(2);
        fadeTransition.setCycleCount(2);

        scaleTransition.play();
        fadeTransition.play();
    }

    //Take an image.
    //Transition scale 0 -> screensize 
    //Transition time X
    //Transition Opacity flat or 0 -> X?
    //Play a sound

    
}
*/