package reft.refactor;

import reft.common.model.Location;

public class ReplaceSourceChange extends SourceChange {
    private String replacement;

    public ReplaceSourceChange(Location location, String replacement) {
        super(location);
        this.replacement = replacement;
    }

    public String getReplacement() {
        return replacement;
    }

    @Override
    public String toString() {
        return "Replace text at " + getLocation() + " with " + getReplacement();
    }
}
