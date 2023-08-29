package adventuregame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import adventuregame.console.ConsoleManager;
import adventuregame.console.LogType;
import adventuregame.locations.Location;
import adventuregame.locations.objects.InteractableObject;
import adventuregame.player.Player;
import adventuregame.quests.MainQuest;
import adventuregame.quests.QuestManager;
import adventuregame.util.ActionOption;
import adventuregame.util.ActionOption.MoveActionOption;
import adventuregame.util.ActionOption.InteractActionOption;
import adventuregame.util.ActionOption.InventoryActionOption;
import adventuregame.util.GameFlags;
import adventuregame.util.GameState;
import jcurses.system.InputChar;
import jcurses.system.Toolkit;

public final class Game {
    public static GameState gameState = GameState.NULL;
    public static HashMap<GameFlags, Boolean> gameFlags = new HashMap<GameFlags, Boolean>();

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
        Location store = new Location("store")
                            .addObject(new InteractableObject("test", "test"))
                            .addConnection(
                                new Location("parkingLot")
                            );

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

        ResourceBundle flavorBundle = ResourceBundle.getBundle("localization.flavor.FlavorText");

        ArrayList<ActionOption> options = new ArrayList<ActionOption>();
        // add connections as action options
        for (Location connection : player.getLocation().getConnections()) {
            options.add(new MoveActionOption(flavorBundle.getString("locationMovement") + connection.getName(), connection));
        }
        // add interactable objects to room
        for (InteractableObject object : player.getLocation().getObjects()) {
            // TODO: implement item names and stuff
            options.add(new InteractActionOption(flavorBundle.getString("interact") + "milk", object));
        }
        // inventory stuff
        options.add(new InventoryActionOption(flavorBundle.getString("inventoryCheck")));

        ActionOption choosenOption = promptUser(flavorBundle.getString("actionPrompt"), options);

        // IF move locations
            // check for move blockers, proceed to fight/interaction if there are
            // if player cannot move, end turn
        if (choosenOption.getClass().equals(MoveActionOption.class)) {
            
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

    private static ActionOption promptUser(String prompt, ActionOption[] options) {
        ConsoleManager.log(LogType.PROMPT, prompt);
        for (int i = 0; i < options.length; i++) {
            ConsoleManager.log(LogType.PROMPT, ConsoleManager.TAB + (i+1) + ". " + options[i].actionDescription);
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

        return options[ch];
    }

    private static ActionOption promptUser(String prompt, ArrayList<ActionOption> options) {
        ActionOption[] strArray = new ActionOption[options.size()];
        return promptUser(prompt, options.toArray(strArray));
    }
}