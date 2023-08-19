package adventuregame.Quests.Objectives;

import adventuregame.Game;

public class HasItemObjective extends Objective {
    
    public HasItemObjective(String name, String description) {
        super(name, description);
    }

    @Override
    public boolean isCompleted(Game game) {
        return false;
    }
}