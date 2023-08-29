package adventuregame.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class Localization {
    private static Localization INSTANCE;

    private Locale locale;
    private ResourceBundle gameBundle;
    private ResourceBundle itemsBundle;
    private ResourceBundle locationsBundle;
    private ResourceBundle blockersBundle;
    private ResourceBundle interactablesBundle;

    public Localization(String language) {
        locale = new Locale(language);

        constructBundles();
    }

    public Localization() {
        this("en");
    }

    private void constructBundles() {
        this.gameBundle = ResourceBundle.getBundle("localization.game.Game", locale);
        this.itemsBundle = ResourceBundle.getBundle("localization.items.Items", locale);
        this.locationsBundle = ResourceBundle.getBundle("localization.locations.Locations", locale);
        this.blockersBundle = ResourceBundle.getBundle("localization.locations.blockers.Blockers", locale);
        this.interactablesBundle = ResourceBundle.getBundle("localization.locations.interactables.Interactables", locale);
    }

    public void setLanguage(String language) {
        locale = new Locale(language);
        constructBundles();
    }

    public Locale getLocale() {
        return locale;
    }

    public ResourceBundle getGameBundle() {
        return gameBundle;
    }

    public ResourceBundle getItemsBundle() {
        return itemsBundle;
    }

    public ResourceBundle getLocationsBundle() {
        return locationsBundle;
    }

    public ResourceBundle getBlockersBundle() {
        return blockersBundle;
    }

    public ResourceBundle getInteractablesBundle() {
        return interactablesBundle;
    }

    public static Localization getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Localization();
        }
        return INSTANCE;
    }
}
