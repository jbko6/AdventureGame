package adventuregame.quests.objectives;


public abstract class Objective {
    protected final String name;
    protected final String description;

    public Objective(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public abstract boolean isCompleted();
}