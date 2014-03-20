package reft.model;

import java.util.Collection;

public class MethodInvocation {
    private final QualifiedName name;

    private Collection<Object> parameters;
    private final Location nameLocation;

    public MethodInvocation(QualifiedName name, Location nameLocation, Collection<Object> parameters) {

        this.name = name;
        this.nameLocation = nameLocation;
        this.parameters = parameters;
    }

    public QualifiedName getName() {
        return name;
    }

    public Location getNameLocation() {
        return nameLocation;
    }

    public Collection<Object> getParameters() {
        return parameters;
    }

    public void setParameters(Collection<Object> parameters) {
        this.parameters = parameters;
    }

}
