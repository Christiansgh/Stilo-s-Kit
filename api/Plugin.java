package api;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Plugin {
    private ImageView pluginImageView;
    private Image pluginImage;

    public Plugin(Image pluginImage, ImageView pluginImageView) {
        this.pluginImageView = pluginImageView;
        this.pluginImage = pluginImage;
    }  
}
