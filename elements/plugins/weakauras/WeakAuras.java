package elements.plugins.weakauras;

import javafx.animation.ScaleTransition;
import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class WeakAuras {
    private Node image;
    private int startScaleSize;
    private int endScaleSize;
    private double startOpacity;
    private double endOpacity;
    private int transitionTimeMillis;

    public void activate() {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(transitionTimeMillis), image);
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(transitionTimeMillis), image);
        scaleTransition.setToX(endScaleSize);
        scaleTransition.setToY(endScaleSize);
        fadeTransition.setFromValue(startOpacity);
        fadeTransition.setToValue(endOpacity);
        scaleTransition.play();
    }

    //Take an image.
    //Transition scale 0 -> screensize 
    //Transition time X
    //Transition Opacity flat or 0 -> X?
    //Play a sound

    
}
