package adventuregame.locations;

import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.annotation.CheckForNull;

import adventuregame.locations.blockers.Blocker;
import adventuregame.locations.objects.InteractableObject;
import adventuregame.util.Localization;
import adventuregame.util.LocalizedObject;

public class Location extends LocalizedObject {
    @CheckForNull
    protected Blocker blocker;

    protected final ArrayList<Location> CONNECTIONS = new ArrayList<Location>();
    protected final ArrayList<InteractableObject> OBJECTS = new ArrayList<InteractableObject>();

    public Location(String resourceName) {
        super(resourceName, Localization.getInstance().getLocationsBundle());
    }

    public Location(String resourceName, Blocker blocker) {
        this(resourceName);
        this.blocker = blocker;
    }

    @Deprecated
    public Location() {
        super("", "");
    }

    public Location setName(String name) {
        this.name = name;
        return this;
    }

    public Location setDescription(String description) {
        this.description = description;
        return this;
    }

    public Location setBlocker(Blocker blocker) {
        this.blocker = blocker;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Location> getConnections() {
        return CONNECTIONS;
    }

    public String getConnectionDescription(Location connection) {
        ResourceBundle locationsBundle = Localization.getInstance().getLocationsBundle();

        return locationsBundle.getString(this.RESOURCE_NAME + connection.RESOURCE_NAME + "ConnectionDescription");
    }
    
    /**
     * This method could return null!
     * @see {@link #hasBlocker()} for null check
     */
    @CheckForNull
    public Blocker getBlocker() {
        return blocker;
    }

    public ArrayList<InteractableObject> getObjects() {
        return OBJECTS;
    }

    public boolean hasBlocker() {
        return !(blocker == null);
    }

    public boolean hasConnectionDescription(Location connection) {
        ResourceBundle locationsBundle = Localization.getInstance().getLocationsBundle();

        return locationsBundle.containsKey(this.RESOURCE_NAME + connection.RESOURCE_NAME + "ConnectionDescription");
    }

    public Location addConnection(Location connection, boolean oneWay) {
        this.CONNECTIONS.add(connection);
        if (!oneWay && !connection.getConnections().contains(this)) {
            connection.addConnection(this);
        }
        return this;
    }

    public Location addConnection(Location connection) {
        return addConnection(connection, false);
    }

    public Location addObject(InteractableObject object) {
        this.OBJECTS.add(object);
        return this;
    }
}
