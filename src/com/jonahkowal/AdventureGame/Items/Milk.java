package AdventureGame.Items;

import AdventureGame.Game;

public class Milk extends Item {
    public Milk() {
        this.name = "Milk";
        this.description = "A carton of milk. Boring and bland.";
    }

    @Override
    public boolean use(Game game) {
        System.out.println("You drank the milk.");
        return true;
    }
}
