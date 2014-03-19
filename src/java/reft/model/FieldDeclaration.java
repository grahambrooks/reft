package reft.model;

import java.util.Collection;

public interface FieldDeclaration extends AnnotatedName {

    void addFieldType(String fieldType);
    
    ClassFile getOwningClass();

    Collection<String> getFieldTypes();

}
