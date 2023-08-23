package adventuregame.quests.objectives;

import adventuregame.Game;
import adventuregame.items.Items;

public class ObtainItemObjective extends Objective {

    Items requiredItem;
    
    public ObtainItemObjective(String name, String description, Items requiredItem) {
        super(name, description);

        this.requiredItem = requiredItem;
    }

    @Override
    public boolean isCompleted() {
        return Game.getPlayer().getInventory().hasItem(requiredItem);
    }
}
