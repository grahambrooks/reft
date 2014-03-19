package reft.refactor;

import reft.common.model.Location;

public class SourceChange {
    private Location location;

    public SourceChange(Location location) {

        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}
