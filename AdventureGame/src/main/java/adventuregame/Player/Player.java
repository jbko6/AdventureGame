package adventuregame.player;

import adventuregame.console.ConsoleManager;
import adventuregame.console.LogType;
import adventuregame.locations.Location;

public class Player {
    
    private int health;
    private int xp;
    private Inventory inventory;
    private Location currentLocation;

    public Player() {
        this.health = 20;
        this.xp = 0;
        this.inventory = new Inventory();
    }

    public void damage(int amount, boolean alertPlayer) {
        health -= amount;
        ConsoleManager.log(LogType.DAMAGE, "You were damaged for " + amount + " hit points! Your health is now at " + health + " hit points.");
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

    public Location getLocation() {
        return currentLocation;
    }

    public void setLocation(Location location) {
        this.currentLocation = location;
    }
}
