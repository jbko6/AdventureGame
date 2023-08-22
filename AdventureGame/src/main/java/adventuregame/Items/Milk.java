package adventuregame.items;

import adventuregame.console.ConsoleManager;
import adventuregame.console.LogType;

public class Milk extends Item {
    public Milk() {
        super("Milk", "A carton of milk. Boring and bland.");
    }

    @Override
    public boolean use() {
        ConsoleManager.log(LogType.ACTION, "You drank the milk.");
        return true;
    }
}
