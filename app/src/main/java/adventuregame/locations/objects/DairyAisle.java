package adventuregame.locations.objects;

import java.util.ResourceBundle;

import adventuregame.Game;
import adventuregame.console.ConsoleManager;
import adventuregame.console.LogType;
import adventuregame.items.Items;
import adventuregame.items.Milk;
import adventuregame.util.ActionOption;
import adventuregame.util.Localization;
import adventuregame.util.Prompt;

public class DairyAisle extends InteractableObject {
    public DairyAisle() {
        super("dairyAisle");
    }

    @Override
    public void interact() {
        ResourceBundle interactablesBundle = Localization.getInstance().getInteractablesBundle();
        ResourceBundle gameBundle = Localization.getInstance().getGameBundle();

        ConsoleManager.log(this.description);

        ActionOption getMilk;
        boolean playerHasMilk = Game.getPlayer().getInventory().hasItem(Items.MILK);
        if (!playerHasMilk) {
            getMilk = new ActionOption(interactablesBundle.getString(RESOURCE_NAME + "GetMilk"));
        } else {
            getMilk = new ActionOption(interactablesBundle.getString(RESOURCE_NAME + "GetMilkAgain"));
        }
        ActionOption leave = new ActionOption(interactablesBundle.getString(RESOURCE_NAME + "Leave"));

        ActionOption choosenOption = Prompt.promptUser(gameBundle.getString("actionPrompt"), new ActionOption[]{getMilk, leave});

        if (choosenOption == getMilk) {
            if (!playerHasMilk) {
                ConsoleManager.log(interactablesBundle.getString(RESOURCE_NAME + "FindMilk"));
                Game.getPlayer().getInventory().addItem(new Milk(), true);

                this.description = interactablesBundle.getString(RESOURCE_NAME + "DescriptionPostMilk");
            } else {
                ConsoleManager.log(interactablesBundle.getString(RESOURCE_NAME + "FindNoMilk"));
            }
        }
    }
}
