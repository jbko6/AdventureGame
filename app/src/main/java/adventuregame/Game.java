package adventuregame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import adventuregame.console.ConsoleManager;
import adventuregame.console.LogType;
import adventuregame.items.Items;
import adventuregame.locations.Location;
import adventuregame.locations.blockers.ItemBlocker;
import adventuregame.locations.objects.DairyAisle;
import adventuregame.locations.objects.InteractableObject;
import adventuregame.locations.objects.characters.enemies.Enemy;
import adventuregame.player.Player;
import adventuregame.quests.MainQuest;
import adventuregame.quests.QuestManager;
import adventuregame.util.ActionOption;
import adventuregame.util.ActionOption.MoveActionOption;
import adventuregame.util.ActionOption.InteractActionOption;
import adventuregame.util.ActionOption.InventoryActionOption;
import adventuregame.util.GameFlags;
import adventuregame.util.GameState;
import adventuregame.util.Localization;
import adventuregame.util.Prompt;
import jcurses.system.Toolkit;

public final class Game {
    public static final HashMap<GameFlags, Boolean> GAME_FLAGS = new HashMap<GameFlags, Boolean>();

    public static GameState gameState = GameState.NULL;

    private static Player player = new Player();
    private static QuestManager questManager = new QuestManager();
    private static boolean endGameFlag = false;

    public static void startGame() {
        Location store = new Location("store")
                            .addObject(new DairyAisle())
                            .addConnection(
                                new Location("parkingLot")
                                    .setBlocker(new ItemBlocker("obtainMilk", Items.MILK))
                            );

        player.setLocation(store);

        //player.getInventory().addItem(new Milk());

        questManager.addQuest(new MainQuest());

        gameLoop();
    }

    private static void gameLoop() {
        // inform user of surroundings and stats
        gameState = GameState.INFORM;
        ConsoleManager.log(LogType.INFO, player.getLocation().getDescription());

        // prompt user for action (move locations, interact with object (object, character, enemy),  use item)
        gameState = GameState.PROMPT;

        ResourceBundle gameBundle = Localization.getInstance().getGameBundle();

        ArrayList<ActionOption> options = new ArrayList<ActionOption>();
        // add connections as action options
        for (Location connection : player.getLocation().getConnections()) {
            options.add(new MoveActionOption(gameBundle.getString("locationMovement") + connection.getName(), connection));
        }
        // add interactable objects to room
        for (InteractableObject object : player.getLocation().getObjects()) {
            options.add(new InteractActionOption(gameBundle.getString("interact") + object.getName(), object));
        }
        // inventory stuff
        options.add(new InventoryActionOption(gameBundle.getString("inventoryCheck")));

        ActionOption choosenOption = Prompt.promptUser(gameBundle.getString("actionPrompt"), options);

        // IF move locations
            // check for move blockers, proceed to fight/interaction if there are
            // if player cannot move, end turn
        if (choosenOption.getClass().equals(MoveActionOption.class)) {
            MoveActionOption moveAction = (MoveActionOption) choosenOption;

            // check for blocker on the location
            if(moveAction.location.hasBlocker() && !moveAction.location.getBlocker().isDisabled()) {
                // if unable to move, log to the user why
                ConsoleManager.log(LogType.INFO, moveAction.location.getBlocker().getDescription());
            } else {
                if (player.getLocation().hasConnectionDescription(moveAction.location)) {
                    ConsoleManager.log(LogType.INFO, player.getLocation().getConnectionDescription(moveAction.location));
                }

                player.setLocation(moveAction.location);
            }
        }

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
        if (choosenOption.getClass().equals(InteractActionOption.class)) {
            InteractActionOption interactAction = (InteractActionOption) choosenOption;

            interactAction.object.interact();
        }

        // IF use item
            // use item
            // update quests, end turn
        if (choosenOption.getClass().equals(InventoryActionOption.class)) {

        }

        questManager.updateQuests();
        endTurn();
    }

    private static void endTurn() {
        if (player.getHealth() > 0 && !endGameFlag) {
            ConsoleManager.newLine();
            ConsoleManager.log("(Press any key to proceed to next turn)");
            Toolkit.readCharacter();
            ConsoleManager.log("\033[F------------ END TURN ------------                    ");
            ConsoleManager.newLine();
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

    public static Player getPlayer() {
        return player;
    }

    public static QuestManager getQuestManager() {
        return questManager;
    }
}