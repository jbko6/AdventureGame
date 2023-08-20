package adventuregame.quests;

import adventuregame.items.Items;
import adventuregame.quests.objectives.ObtainItemObjective;

public class MainQuest extends Quest {

    public MainQuest() {
        this.title = "Main Quest";

        this.sequence.add(new ObtainItemObjective("Obtain Milk", "Seek out milk from the grocery store", Items.MILK));
    }
}
