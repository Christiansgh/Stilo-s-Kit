package elements.resources;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.SVGPath;

/*
 * Has getter methods for all the sub elements of the gui.
 * In individual classes, each element is called with a getter method.
 * - multiple times to combine.
 */

public class Resources {
    //Images
    public static Image getWA() {
        Image wa = new Image("elements/resources/images/WA.png", 20, 20, true, true);
        return wa;
    }
    
    public static Image getList() {
        Image list = new Image("elements/resources/images/list.png", 20, 20, true, true);
        return list;
    }
    
    public static Image getLogo(int sizeX, int sizeY) {
        Image logo = new Image("elements/resources/images/logo.png", 20, 20, true, true);
        return logo;
    }

    public static Image getLogoApplication(int sizeX, int sizeY) {
        Image logo = new Image("elements/resources/images/applicationLogo.png");
        return logo;
    }

    public static ImageView getItemOverload() {
        Image overload = new Image("elements/resources/images/overload.png");
        ImageView ImageView = new ImageView(overload);
        return ImageView;
    }

    //Plugin windows

    //Setting windows 

    //Icons
    public static SVGPath getIconClose() {
        SVGPath closeIcon = new SVGPath();
        closeIcon.setContent("M3.26,2.998L3.26,1.013L3.992,1.013L3.992,2.998L6.025,2.998L6.025,3.745L3.992,3.745L3.992,5.746L3.26,5.746L3.26,3.745L1.304,3.745L1.304,2.998L3.26,2.998Z");
        closeIcon.setScaleX(3);
        closeIcon.setScaleY(3);
        closeIcon.setRotate(45);
        return closeIcon;
    }

    public static SVGPath getIconToggleSidebar() {
        SVGPath toggleSideIcon = new SVGPath();
        toggleSideIcon.setContent("M19.651,0.409L19.651,4.608L14.562,8.335L19.651,11.908L19.651,16.174L10.342,8.335L19.651,0.409Z");
        toggleSideIcon.setScaleX(0.8);
        toggleSideIcon.setScaleY(0.8);
        return toggleSideIcon;
    }

    public static SVGPath getIconRefresh() {
        SVGPath refreshIcon = new SVGPath();
        refreshIcon.setContent("M5.1,3.77L9.989,7.323L9.989,5.009C13.997,5.444 15.847,7.529 16.117,10.745C16.138,15.287 13.793,17.166 9.989,17.362C6.741,17.373 4.687,15.504 3.699,11.691L1.547,11.691C2.526,16.42 5.099,19.272 9.989,19.481C15.21,18.961 18.111,16.132 18.464,10.745C17.895,5.79 14.992,3.152 9.989,2.629L9.989,0.152L5.1,3.77Z");
        refreshIcon.setScaleX(0.8);
        refreshIcon.setScaleY(0.8);
        return refreshIcon;
    }

    public static SVGPath getIconLogger() {
        SVGPath loggerIcon = new SVGPath();
        loggerIcon.setContent("M8 8H16M8 12H16M10 16H14M3.5 12C3.5 5.5 5.5 3.5 12 3.5C18.5 3.5 20.5 5.5 20.5 12C20.5 18.5 18.5 20.5 12 20.5C5.5 20.5 3.5 18.5 3.5 12Z");
        return loggerIcon;
    }
}
