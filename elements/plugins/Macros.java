package elements.plugins;

import api.Plugin;
import javafx.scene.Node;

public class Macros extends Plugin {
    private static Macros macros = null;

    private Macros(boolean isVisible, boolean isActive, Node pluginIcon, Node pluginWindow) {
        super(isVisible, isActive, pluginIcon, pluginWindow);
    }

    public static Macros getInstance() {
        if (macros == null) {
            macros = new Macros(true, false, null, null);
        }

        return macros;
    }

    @Override
    public void toggleVisible() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void toggleActive() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void initialize() {
        // TODO Auto-generated method stub
        
    }
    
}
