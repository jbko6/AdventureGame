package adventuregame;

import adventuregame.console.ConsoleManager;
import adventuregame.console.LogType;
import adventuregame.items.Items;
import adventuregame.items.Milk;
import adventuregame.items.Poison;
import adventuregame.locations.Location;
import adventuregame.player.Player;
import adventuregame.quests.MainQuest;
import adventuregame.quests.QuestManager;

public final class Game {
    private static Player player = new Player();
    private static QuestManager questManager = new QuestManager();

    private static boolean endGameFlag = false;

    public static Player getPlayer() {
        return player;
    }

    public static QuestManager getQuestManager() {
        return questManager;
    }

    public static void startGame() {
        ConsoleManager.log(LogType.INFO, "welcome! test");
        player.getInventory().addItem(new Milk());
        player.getInventory().addItem(new Milk());
        ConsoleManager.log(LogType.INFO, player.getInventory().toString());
        player.getInventory().addItem(new Poison());
        player.getInventory().useItem(Items.POISON);
        ConsoleManager.log(LogType.INFO, player.getInventory().toString());

        Location store = new Location("Store", "The store")
                            .addConnection(new Location("Parking Lot", "It's a parking lot for the store."));
        ConsoleManager.log(store.getConnections().get(0).getName());
        ConsoleManager.log(store.getConnections().get(0).getConnections().get(0).getName());

        questManager.addQuest(new MainQuest());

        gameLoop();
    }

    private static void gameLoop() {
        // inform user of surroundings and stats
        
        // prompt user for action (move locations, interact with object (object, character, enemy),  use item)

        // IF move locations
            // check for move blockers, proceed to fight/interaction if there are
            // if player cannot move, end turn
        
        // IF interact with object
            // IF object
                // display text for object
                // if additional prompts needed, display them
                // repeat until interaction is complete
            // IF character
                // display text for character
                // prompt player
                // provide opportunities to end chat
                // continue chat until convo is complete
            // IF enemy
                // display text for character
                // prompt player
                // enemy takes turn, player takes turn
                // continue until fight complete
                // display rewards text if there is reward
            // then update quests, end turn
        
            // IF use item
                // use item
                // update quests, end turn

        questManager.updateQuests();
        endTurn();
    }

    private static void endTurn() {
        if (player.getHealth() > 0 && !endGameFlag) {
            gameLoop();
        }
    }

    public static void endGame(boolean urgent) {
        if (urgent) {
            System.exit(0);
            return;
        }
        endGameFlag = true;
    }
}
