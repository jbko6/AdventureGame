package adventuregame.Player;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import adventuregame.Game;
import adventuregame.Items.Item;
import adventuregame.Items.Items;

public class Inventory {
    private ListMultimap<Items, Item> items;

    private Game game;

    public Inventory(Game game) {
        items = ArrayListMultimap.create();
        this.game = game;
    }

    public void addItem(Item item) {
        items.put(Items.valueOf(item.getName().toUpperCase()), item);
    }

    public void useItem(Items item) {
        if (hasItem(item)) {
            boolean destroysItem = items.get(item).get(0).use(game);
            if (destroysItem) {
                items.remove(item, items.get(item).get(0));
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
