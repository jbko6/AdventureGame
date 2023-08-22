package adventuregame.console;

public final class ConsoleManager {
    private static final String ANSI_RESET = "\u001B[0m";

    public static void log(LogType type, String msg) {
        System.out.println(type.getColor() + msg + ANSI_RESET);
    }

    public static void log(String msg) {
        log(LogType.INFO, msg);
    }
}
