package reft.common.model;

import javax.lang.model.element.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DefaultAnnotatedName implements AnnotatedName {

    private String name = null;

    private Collection<Annotation> annontations = new ArrayList<Annotation>();
    List<Modifier> modifiers = new ArrayList<>();

    public void addModifiers(Collection<Modifier> modifiers) {
        this.modifiers.addAll(modifiers);
    }

    private Location locationInfo;

    public boolean isAbstract() {
        return modifiers.contains(Modifier.ABSTRACT);
    }

    public boolean isFinal() {
        return modifiers.contains(Modifier.FINAL);
    }

    public boolean isNative() {
        return modifiers.contains(Modifier.NATIVE);
    }

    public boolean isPrivate() {
        return modifiers.contains(Modifier.PRIVATE);
    }

    public boolean isProtected() {
        return modifiers.contains(Modifier.PROTECTED);
    }

    public boolean isPublic() {
        return modifiers.contains(Modifier.PUBLIC);
    }

    public boolean isStatic() {
        return modifiers.contains(Modifier.STATIC);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Annotation> getAnnotations() {
        return annontations;
    }

    public void addAnnotation(Annotation annotation) {
        annontations.add(annotation);
    }

    public Location getLocationInfo() {
        return locationInfo;
    }

    public void setLocationInfo(Location locationInfo) {
        this.locationInfo = locationInfo;
    }

}
