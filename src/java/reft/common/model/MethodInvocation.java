package reft.common.model;

import reft.common.QualifiedName;

import java.util.Collection;

public class MethodInvocation {
    private QualifiedName name;
    private Collection<Object> parameters;
    private Location nameLocation;

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
}
