package reft.common.model;


public class JavaAnnotation implements Annotation {

    private String name;

    public JavaAnnotation(String qualifiedName) {
        this.name = qualifiedName;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Annotation Name: " + name);
        buffer.append("\n");
        return buffer.toString();
    }
}
