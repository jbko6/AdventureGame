package adventuregame.locations.blockers;


import adventuregame.util.Localization;
import adventuregame.util.LocalizedObject;

/**
 * The {@link adventure} class is used to describe an obstacle that must be removed for a location to be accessed.
 * MoveBlocker uses various subclasses to describe the obstacles that may appear in the way of the player.
 * See {@link adventuregame.locations.blockers.ItemBlocker} for an example.
 */
public abstract class Blocker extends LocalizedObject {

    public Blocker(String resourceName) {
        super(resourceName, Localization.getInstance().getBlockersBundle());
    }

    /**
     * Has the block condition been fulfilled?
     *  */ 
    public abstract boolean isDisabled();

    /** 
     * @return a description of the block
     *  */
    public String getDescription() {
        return description;
    }
}