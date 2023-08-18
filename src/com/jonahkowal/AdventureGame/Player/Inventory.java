package AdventureGame.Player;

import java.util.HashMap;

import AdventureGame.Game;
import AdventureGame.Items.Item;
import AdventureGame.Items.Items;

public class Inventory {
    private HashMap<Items, Item> items;

    private Game game;

    public Inventory(Game game) {
        items = new HashMap<>();
        this.game = game;
    }

    public void addItem(Item item) {
        items.put(Items.valueOf(item.getName().toUpperCase()), item);
    }

    public void useItem(Items item) {
        if (hasItem(item)) {
            boolean destroysItem = items.get(item).use(game);
            if (destroysItem) {
                items.remove(item);
            }
        }
    }

    public boolean hasItem(Items item) {
        return items.containsKey(item);
    }

    public String toString() {
        return items.toString();
    }
}
