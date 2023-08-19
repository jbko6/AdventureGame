package adventuregame.Items;

import adventuregame.Game;

public abstract class Item {
    protected String name;
    protected String description;

    public String getName() {
        return name;
    }

    public abstract boolean use(Game game);
}
