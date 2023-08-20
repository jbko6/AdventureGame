package adventuregame.quests;

import java.util.ArrayList;

public class QuestManager {
    private ArrayList<Quest> quests = new ArrayList<>();

    public QuestManager() {

    }

    public void addQuest(Quest quest) {
        quests.add(quest);
    }

    public void updateQuests() {
        ArrayList<Quest> completedQuests = new ArrayList<>();

        for (Quest quest : quests) {
            if (quest.checkProgress(true)) {
                boolean questComplete = quest.checkCompletion();
                if (questComplete) {
                    System.out.println("You completed the quest " + quest.getTitle() + "!");
                    completedQuests.add(quest);
                }
            }
        }

        for (Quest quest : completedQuests) {
            quests.remove(quest);
        }
    }
}
