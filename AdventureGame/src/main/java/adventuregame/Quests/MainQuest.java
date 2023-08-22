package adventuregame.quests;

import adventuregame.items.Items;
import adventuregame.quests.objectives.ObtainItemObjective;

public class MainQuest extends Quest {

    public MainQuest() {
        super("Main Quest");

        this.sequence.add(new ObtainItemObjective("Obtain Poison", "You're going to need poison to murder your neighbor.", Items.POISON));
        this.sequence.add(new ObtainItemObjective("Obtain Milk", "Seek out milk from the grocery store", Items.MILK));
    }
}
