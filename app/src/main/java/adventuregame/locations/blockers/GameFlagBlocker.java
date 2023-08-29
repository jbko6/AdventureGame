package adventuregame.locations.blockers;

import adventuregame.Game;
import adventuregame.util.GameFlags;

public class GameFlagBlocker extends Blocker {

    GameFlags flag;
    boolean neededState;

    public GameFlagBlocker(String resourceName, GameFlags flag, boolean neededState) {
        super(resourceName);
        this.flag = flag;
        this.neededState = neededState;
    }

    public boolean isDisabled() {
        if (Game.GAME_FLAGS.containsKey(flag)) {
            return Game.GAME_FLAGS.get(flag) == neededState;
        }
        return false;
    }
    
}
