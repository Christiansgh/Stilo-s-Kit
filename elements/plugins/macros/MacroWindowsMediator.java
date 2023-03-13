package elements.plugins.macros;

import java.util.ArrayList;

import utils.WindowMediator;

public final class MacroWindowsMediator implements WindowMediator {
    private static ArrayList<Icon> iconWindows;
    private static MacroWindowsMediator mediator = null;

    private MacroWindowsMediator() {};

    public static MacroWindowsMediator getInstance() {
        if (mediator == null) {
            iconWindows = new ArrayList<Icon>();
            mediator = new MacroWindowsMediator();
        }

        return mediator;
    }

    @Override
    public void notify(Icon sender) {
        System.out.println("Notify");
        for (Icon icon : iconWindows) {
            if (icon != sender) {
                icon.getSettings().setVisible(false);
                icon.setVisible(false);
            }
        }
    }

    public void addWindow(Icon icon) {
        iconWindows.add(icon);
    }
}
