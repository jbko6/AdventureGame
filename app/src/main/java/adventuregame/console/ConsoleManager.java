package adventuregame.console;

public final class ConsoleManager {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String TAB = "    ";

    public static void log(LogType type, String msg) {
        System.out.println(type.getColor() + msg + ANSI_RESET);
    }

    public static void log(String msg) {
        log(LogType.INFO, msg);
    }

    public static void error(String msg) {
        System.out.println(LogType.ERROR + msg + ANSI_RESET);
    }

    public static void newLine() {
        System.out.println();
    }
}
