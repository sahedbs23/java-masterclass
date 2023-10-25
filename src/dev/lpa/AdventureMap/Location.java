package dev.lpa.AdventureMap;

import java.util.HashMap;
import java.util.Map;


public class Location {
    private String name;
    private String description;

    private Map<Direction, Location> nextLocation;

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
        nextLocation = new HashMap<>();
    }

    public boolean addNextLocation(Direction direction, Location nextLocation) {
        Location location = this.nextLocation.put(direction, nextLocation);
        return location != null;
    }

    @Override
    public String toString() {
        return "%s -> %s".formatted(name, description);
    }
}
