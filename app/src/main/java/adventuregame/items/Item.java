package adventuregame.items;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import adventuregame.util.Localization;
import adventuregame.util.LocalizedObject;

public abstract class Item extends LocalizedObject {

    public Item(String resourceName) {
        super(resourceName, Localization.getInstance().getItemsBundle());
    }

    @Deprecated
    public Item(String name, String description) {
        super(name, description);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    protected String getLocalizedString(String keyword) {
        ResourceBundle locationsBundle = Localization.getInstance().getItemsBundle();
        try {
            return locationsBundle.getString(RESOURCE_NAME + keyword);
        } catch (MissingResourceException e) {
            System.err.println(keyword + " resource did not exist.");
        }
        // we shouldn't reach this return unless something went wrong
        return "whoops";
    }

    public abstract boolean use();
}
