package reft.model;


public class JavaAnnotation implements Annotation {

    private final String name;

    public JavaAnnotation(String qualifiedName) {
        this.name = qualifiedName;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Annotation Name: " + name + "\n";
    }
}
