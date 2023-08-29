package adventuregame.items.weapons;

import adventuregame.items.Item;

public abstract class Weapon extends Item {

    protected final int baseDamage;
    protected final double critRate;

    public Weapon(String resourceName, int baseDamage, double critRate) {
        super(resourceName);

        this.baseDamage = baseDamage;
        this.critRate = critRate;
    }
    
}
