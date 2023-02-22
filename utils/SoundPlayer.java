package utils;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundPlayer {
    public static void playSound(String soundName) {
        
        Media media = new Media(new File("elements/resources/sounds/tts/"+soundName).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
}
