package adventuregame.util;

import adventuregame.locations.Location;
import adventuregame.locations.objects.InteractableObject;

public abstract class ActionOption {
    public String actionDescription;

    public ActionOption(String actionDescription) {
        this.actionDescription = actionDescription;
    }

    public static class MoveActionOption extends ActionOption {
        public Location location;
        
        public MoveActionOption(String actionDescription, Location location) {
            super(actionDescription);
            this.location = location;
        }
    }

    public static class InteractActionOption extends ActionOption {
        public InteractableObject object;

        public InteractActionOption(String actionDescription, InteractableObject object) {
            super(actionDescription);
            this.object = object;
        }
    }

    public static class InventoryActionOption extends ActionOption {
        public InventoryActionOption(String actionDescription) {
            super(actionDescription);
        }
    }

}
