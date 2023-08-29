package adventuregame.items;

import adventuregame.Game;
import adventuregame.console.ConsoleManager;
import adventuregame.console.LogType;

public class Poison extends Item {
    public Poison() {
        super("poison");
    }

    @Override
    public boolean use() {
        ConsoleManager.log(LogType.ACTION, getLocalizedString("Use"));
        Game.getPlayer().damage(5, true);
        return true;
    }
}
