package adventuregame.util;

import java.util.ResourceBundle;

public abstract class LocalizedObject {
    protected final String RESOURCE_NAME;

    protected String name;
    protected String description;

    public LocalizedObject(String resourceName, ResourceBundle bundle) {
        this.RESOURCE_NAME = resourceName;

        if (bundle.containsKey(resourceName + "Name")) {
            this.name = bundle.getString(resourceName + "Name");
        } else {
            this.name = "";
        }

        if (bundle.containsKey(resourceName + "Description")) {
            this.description = bundle.getString(resourceName + "Description");
        } else {
            this.description = "";
        }
    }
    /**
     * Used only if automatic localization is to be avoided
     */
    public LocalizedObject(String name, String description) {
        this.name = name;
        this.description = description;
        this.RESOURCE_NAME = name;
    }
}
