package adventuregame.locations.blockers;


import adventuregame.Game;
import adventuregame.items.Items;

/**
 * The ItemBlocker class represents an obstacle that is cleared when the player obtains an item
 * @see {@link adventuregame.locations.blockers.Blocker}
 */
public class ItemBlocker extends Blocker {
    private Items item;

    public ItemBlocker(String resourceName, Items item) {
        super(resourceName);
        this.item = item;
    }

    /**
     * For the ItemBlocker block to be disabled, the player must aquire the needed item
     */
    public boolean isDisabled() {
        return Game.getPlayer().getInventory().hasItem(item);
    }
}
