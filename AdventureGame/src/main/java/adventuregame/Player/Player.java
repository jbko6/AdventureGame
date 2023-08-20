package adventuregame.player;


public class Player {
    
    private int health;
    private int xp;
    private Inventory inventory;

    public Player() {
        this.health = 20;
        this.xp = 0;
        this.inventory = new Inventory();
    }

    public void damage(int amount, boolean alertPlayer) {
        health -= amount;
        System.out.println("You were damaged for " + amount + " hit points! Your health is now at " + health + " hit points.");
    }

    public void damage(int amount) {
        damage(amount, false);
    }

    public int getHealth() {
        return health;
    }

    public int getXP() {
        return xp;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
