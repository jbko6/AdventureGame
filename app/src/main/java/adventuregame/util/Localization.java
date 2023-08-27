package adventuregame.util;

import java.util.Locale;

public class Localization {
    private static Localization INSTANCE;

    private Locale locale;

    public Localization(String language) {
        locale = new Locale(language);
    }

    public Localization() {
        this("en");
    }

    public void setLanguage(String language) {
        locale = new Locale(language);
    }

    public Locale getLocale() {
        return locale;
    }

    public static Localization getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Localization();
        }
        return INSTANCE;
    }
}
