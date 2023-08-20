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
     * @return true if progress was made
     */
    public boolean checkProgress(boolean alertPlayer) {
        if (sequence.size() == 0) {
            return false;
        }

        Objective currentObjective = sequence.get(0);

        if (currentObjective.isCompleted()) {
            sequence.remove(currentObjective);

            if (alertPlayer) {
                System.out.println("You completed the quest objective " + currentObjective.getName() + "!");
            }

            checkProgress(true);

            return true;
        }
        return false;
    }

    /**
     * Checks the progress of the quest and updates quest steps if they are completed
     * 
     * @return true if progrss was made
     */
    public boolean checkProgress() {
        return checkProgress(false);
    }

    /**
     * Checks for completion of quest
     * @return true if quest is complete
     */
    public boolean checkCompletion() {
        return sequence.size() == 0;
    }

}
