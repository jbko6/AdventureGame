package adventuregame.Player;

import adventuregame.Game;

public class Player {
    
    private int health;
    private int xp;

    public Inventory inventory;


    public Player(Game game) {
        this.health = 20;
        this.xp = 0;
        this.inventory = new Inventory(game);
    }

    public void damage(int amount) {
        health -= amount;
    }

    public int getHealth() {
        return health;
    }

    public int getXP() {
        return xp;
    }
}
