package adventuregame.items;

import adventuregame.console.ConsoleManager;
import adventuregame.console.LogType;

public class Milk extends Item {
    public Milk() {
        super("milk");
    }

    @Override
    public boolean use() {
        ConsoleManager.log(LogType.ACTION, getLocalizedString("Use"));
        return true;
    }
}
