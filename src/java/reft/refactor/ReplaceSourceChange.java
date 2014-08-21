package reft.refactor;

import reft.StreamEditor;
import reft.model.Location;

public class ReplaceSourceChange extends SourceChange {
    private final String replacement;

    public ReplaceSourceChange(Location location, String replacement) {
        super(location);
        this.replacement = replacement;
    }

    public String getReplacement() {
        return replacement;
    }

    @Override
    public String toString() {
        return "Replacement text at " + getLocation() + " with " + getReplacement();
    }

    @Override
    public StreamEditor.Change toEditorChange() {
        return StreamEditor.replacement(getLocation(), replacement);
    }
}
