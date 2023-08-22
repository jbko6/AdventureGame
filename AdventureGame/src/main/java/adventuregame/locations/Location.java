package adventuregame.locations;

import java.util.ArrayList;

import adventuregame.locations.objects.LocationObject;

public class Location {
    protected final String name;
    protected final String description;
    protected final ArrayList<Location> connections = new ArrayList<Location>();
    protected final ArrayList<LocationObject> objects = new ArrayList<LocationObject>();

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
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

    public Location addObject(LocationObject object) {
        this.objects.add(object);
        return this;
    }

    public ArrayList<LocationObject> getObjects() {
        return objects;
    }
}
