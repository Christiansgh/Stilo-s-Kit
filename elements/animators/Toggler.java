package elements.animators;

import javafx.scene.Node;

public class Toggler {
    public static void toggle(Node node, boolean startState) {
        node.setVisible(startState);
    }
}
