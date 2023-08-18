package AdventureGame.Quests.Objectives;

import AdventureGame.Game;

public abstract class Objective {
    private String name;
    private String description;

    public Objective(String name, String description) {
        this.name = name;
        this.description = description;
    }

    abstract boolean isCompleted(Game game);
}