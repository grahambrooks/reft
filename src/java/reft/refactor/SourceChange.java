package reft.refactor;

import reft.StreamEditor;
import reft.model.Location;

public abstract class SourceChange {
    private final Location location;

    SourceChange(Location location) {

        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
    public abstract StreamEditor.Change toEditorChange();
}
