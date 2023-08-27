package adventuregame.locations;

import java.util.ArrayList;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import adventuregame.locations.objects.InteractableObject;

public class Location {
    protected String name;
    protected String description;
    protected final ArrayList<Location> connections = new ArrayList<Location>();
    protected final ArrayList<InteractableObject> objects = new ArrayList<InteractableObject>();

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Location(String resourceName) {
        ResourceBundle locationsBundle = ResourceBundle.getBundle("localization.locations.Locations");
        try {
            this.name = locationsBundle.getString(resourceName + "Name");
            this.description = locationsBundle.getString(resourceName + "Description");
        } catch (MissingResourceException e) {
            this.name = "";
            this.description = "";
            System.err.println(resourceName + " resource bundle did not exist.");
        }
    }

    public Location() {
        this("", "");
    }

    public Location setName(String name) {
        this.name = name;
        return this;
    }

    public Location setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Location addConnection(Location connection, boolean oneWay) {
        this.connections.add(connection);
        if (!oneWay && !connection.getConnections().contains(this)) {
            connection.addConnection(this);
        }
        return this;
    }

    public Location addConnection(Location connection) {
        return addConnection(connection, false);
    }

    public ArrayList<Location> getConnections() {
        return connections;
    }

    public Location addObject(InteractableObject object) {
        this.objects.add(object);
        return this;
    }

    public ArrayList<InteractableObject> getObjects() {
        return objects;
    }
}
