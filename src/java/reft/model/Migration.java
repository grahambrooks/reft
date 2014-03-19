package reft.model;

public interface Migration {
    void apply(AnnotatedName model);
}
