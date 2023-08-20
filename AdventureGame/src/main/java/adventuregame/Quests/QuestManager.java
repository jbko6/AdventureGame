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
            boolean questComplete = quest.checkProgress(true);
            if (questComplete) {
                System.out.println("You completed the quest " + quest.getTitle() + "!");
                completedQuests.add(quest);
            }
        }

        for (Quest quest : completedQuests) {
            quests.remove(quest);
        }
    }
}
