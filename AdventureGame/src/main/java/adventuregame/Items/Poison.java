package adventuregame.items;

import adventuregame.Game;

public class Poison extends Item {
    public Poison() {
        this.name = "Poison";
        this.description = "Often used in homicide. Don't drink it.";
    }

    @Override
    public boolean use() {
        System.out.println("You drank the poison.");
        Game.getPlayer().damage(5, true);
        return true;
    }
}
