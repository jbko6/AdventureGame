package adventuregame.quests;

import java.util.ArrayList;

import adventuregame.quests.objectives.Objective;

public abstract class Quest {

    protected String title;
    protected ArrayList<Objective> sequence = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    /**
     * Checks the progress of the quest and updates quest steps if they are completed
     * 
     * @param alertPlayer if true, will send a message to the player alerting them if they have made progress on the quest
     * 
     * @return true if the quest has been completed
     */
    public boolean checkProgress(boolean alertPlayer) {
        Objective currentObjective = sequence.get(0);

        if (currentObjective.isCompleted()) {
            sequence.remove(currentObjective);

            if (alertPlayer) {
                System.out.println("You completed the quest objective " + currentObjective.getName() + "!");
            }

            if (sequence.size() == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks the progress of the quest and updates quest steps if they are completed
     * 
     * @return true if the quest has been completed
     */
    public boolean checkProgress() {
        return checkProgress(false);
    }

}
