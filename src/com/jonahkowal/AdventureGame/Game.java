package AdventureGame;

import AdventureGame.Items.Items;
import AdventureGame.Items.Milk;
import AdventureGame.Player.Player;
import AdventureGame.Quests.QuestManager;

public class Game {
    private Player player;
    private QuestManager questManager;

    public Game() {
        this.player = new Player(this);
        this.questManager = new QuestManager();
    }

    public Player getPlayer() {
        return player;
    }

    public QuestManager getQuestManager() {
        return questManager;
    }

    public void startGame() {
        System.out.println("welcome! test");
        player.inventory.addItem(new Milk());
        System.out.println(player.inventory.toString());
        player.inventory.useItem(Items.MILK);
        System.out.println(player.inventory.toString());

        gameLoop();
    }

    private void gameLoop() {
        
    }
}
