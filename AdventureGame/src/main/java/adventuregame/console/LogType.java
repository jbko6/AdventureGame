package adventuregame.console;

public enum LogType {
    ACTION("\u001B[34m"), // blue
    QUEST("\u001B[32m"), // green
    INFO("\u001B[0m"), // white/default
    PROMPT("\u001B[33m"), // yellow
    DAMAGE("\u001B[31m"); // red

    private String color;

    public String getColor() {
        return color;
    }

    private LogType(String color) {
        this.color = color;
    }
}
