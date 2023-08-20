package adventuregame;

import adventuregame.items.Items;
import adventuregame.items.Milk;
import adventuregame.items.Poison;
import adventuregame.player.Player;
import adventuregame.quests.MainQuest;
import adventuregame.quests.QuestManager;

public class Game {
    private static Player player = new Player();
    private static QuestManager questManager = new QuestManager();

    public static Player getPlayer() {
        return player;
    }

    public static QuestManager getQuestManager() {
        return questManager;
    }

    public static void startGame() {
        System.out.println("welcome! test");
        player.getInventory().addItem(new Milk());
        player.getInventory().addItem(new Milk());
        System.out.println(player.getInventory().toString());
        player.getInventory().useItem(Items.MILK);
        player.getInventory().useItem(Items.MILK);
        System.out.println(player.getInventory().toString());
        player.getInventory().addItem(new Poison());
        player.getInventory().useItem(Items.POISON);

        questManager.addQuest(new MainQuest());

        gameLoop();
    }

    private static void gameLoop() {
        questManager.updateQuests();
    }
}
