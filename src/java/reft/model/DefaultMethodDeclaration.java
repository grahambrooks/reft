package reft.model;

import java.util.ArrayList;
import java.util.Collection;

public class DefaultMethodDeclaration extends DefaultAnnotatedName implements MethodDeclaration {

    private ClassFile owningClass;
    private Collection<String> parameters = new ArrayList<>();
    private String returnType;
    private Collection<String> exceptions = new ArrayList<>();

    public ClassFile getOwningClass() {
        return owningClass;
    }

    public void setOwningClass(ClassFile owningClass) {
        this.owningClass = owningClass;
    }

    public Collection<String> getParameters() {
        return parameters;
    }

    public void setParameters(Collection<String> parameters) {
        this.parameters = parameters;
    }

    public void addParameters(String parameter) {
        this.parameters.add(parameter);
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public Collection<String> getExceptions() {
        return exceptions;
    }

    public void setExceptions(Collection<String> exceptions) {
        this.exceptions = exceptions;
    }

    public void addException(String exception) {
        this.exceptions.add(exception);
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("MethodDeclaration Name: ").append(getName());
        buffer.append("\n");
        if (parameters.size() <= 0) {
            buffer.append("No parameters defined ");
            buffer.append("\n");
        }
        for (Object param : parameters) {
            buffer.append(param.toString());
            buffer.append(", ");
        }
        return buffer.toString();
    }
}
