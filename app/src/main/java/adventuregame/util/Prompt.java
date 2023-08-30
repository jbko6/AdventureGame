package adventuregame.util;

import java.util.ArrayList;

import adventuregame.console.ConsoleManager;
import adventuregame.console.LogType;
import jcurses.system.InputChar;
import jcurses.system.Toolkit;

public final class Prompt {
    public static ActionOption promptUser(String prompt, ActionOption[] options) {
        ConsoleManager.log(LogType.PROMPT, prompt);
        for (int i = 0; i < options.length; i++) {
            ConsoleManager.log(LogType.PROMPT, ConsoleManager.TAB + (i+1) + ". " + options[i].actionDescription);
        }

        int ch;
        while (true) {
            InputChar c = Toolkit.readCharacter();
            try {
                ch = Integer.parseInt(c.toString()) - 1;
            } catch(Exception e) {
                continue;
            }
            if (ch + 1 > options.length || ch < 0) {
                continue;
            }
            break;
        }

        ConsoleManager.newLine();

        return options[ch];
    }

    public static ActionOption promptUser(String prompt, ArrayList<ActionOption> options) {
        ActionOption[] strArray = new ActionOption[options.size()];
        return promptUser(prompt, options.toArray(strArray));
    }
}
