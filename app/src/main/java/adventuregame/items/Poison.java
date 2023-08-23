package adventuregame.items;

import adventuregame.Game;
import adventuregame.console.ConsoleManager;
import adventuregame.console.LogType;

public class Poison extends Item {
    public Poison() {
        super("Poison", "Often used in homicide. Don't drink it.");
    }

    @Override
    public boolean use() {
        ConsoleManager.log(LogType.ACTION, "You drank the poison.");
        Game.getPlayer().damage(5, true);
        return true;
    }
}
