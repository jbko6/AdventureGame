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
import adventuregame.util.GameState;
import jcurses.system.InputChar;
import jcurses.system.Toolkit;

public final class Game {
    public static GameState gameState = GameState.NULL;

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

        player.setLocation(store);

        questManager.addQuest(new MainQuest());

        gameLoop();
    }

    private static void gameLoop() {
        // inform user of surroundings and stats
        gameState = GameState.INFORM;
        ConsoleManager.log(LogType.INFO, player.getLocation().getDescription());

        // prompt user for action (move locations, interact with object (object, character, enemy),  use item)
        gameState = GameState.PROMPT;

        String[] options = {"First option", "Second Option", "Third Option"};
        promptUser("Please select an option", options);

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
            // gameLoop();
        }
    }

    public static void endGame(boolean urgent) {
        if (urgent) {
            System.exit(0);
            return;
        }
        endGameFlag = true;
    }

    private static int promptUser(String prompt, String[] options) {
        ConsoleManager.log(LogType.PROMPT, prompt);
        for (int i = 0; i < options.length; i++) {
            ConsoleManager.log(LogType.PROMPT, ConsoleManager.TAB + (i+1) + ". " + options[i]);
        }
        ConsoleManager.newLine();

        int ch;
        while (true) {
            InputChar c = Toolkit.readCharacter();
            try {
                ch = Integer.parseInt(c.toString()) - 1;
            } catch(Exception e) {
                continue;
            }
            if (ch + 1 > options.length || ch < 0) {
                continue;
            }
            break;
        }

        return ch;
    }
}
