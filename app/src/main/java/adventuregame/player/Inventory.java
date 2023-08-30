package adventuregame.player;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import adventuregame.console.ConsoleManager;
import adventuregame.console.LogType;
import adventuregame.items.Item;
import adventuregame.items.Items;

public class Inventory {
    private ListMultimap<Items, Item> items;

    public Inventory() {
        items = ArrayListMultimap.create();
    }

    public void addItem(Item item, boolean alertPlayer) {
        items.put(Items.valueOf(item.getName().toUpperCase()), item);

        if (alertPlayer) {
            ConsoleManager.log(LogType.ACTION, "You obtained " + item.getName());
        }
    }

    public void addItem(Item item) {
        addItem(item, false);
    }

    public void useItem(Items item) {
        if (hasItem(item)) {
            boolean destroysItem = getItem(item).use();
            if (destroysItem) {
                items.remove(item, getItem(item));
            }
        }
    }

    public boolean hasItem(Items item) {
        return items.containsKey(item);
    }

    public Item getItem(Items item, int index) {
        return items.get(item).get(index);
    }

    public Item getItem(Items item) {
        return getItem(item, 0);
    }

    public String toString() {
        return items.toString();
    }
}
