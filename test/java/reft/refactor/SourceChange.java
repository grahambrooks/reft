package reft.refactor;

import reft.model.Location;

public class SourceChange {
    private final Location location;

    SourceChange(Location location) {

        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}
