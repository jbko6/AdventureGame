package adventuregame.locations.objects;

import adventuregame.util.Localization;
import adventuregame.util.LocalizedObject;

public class InteractableObject extends LocalizedObject {

    public InteractableObject(String resourceName) {
        super(resourceName, Localization.getInstance().getInteractablesBundle());
    }

    @Deprecated
    public InteractableObject(String name, String description) {
        super(name, description);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
