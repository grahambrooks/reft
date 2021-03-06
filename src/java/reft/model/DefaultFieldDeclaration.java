package reft.model;

import javax.lang.model.element.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class DefaultFieldDeclaration extends DefaultAnnotatedName implements FieldDeclaration {

    private ClassFile owningClass;
    private final Collection<String> fieldTypes = new ArrayList<>();

    public DefaultFieldDeclaration(QualifiedName name, Set<Modifier> modifiers) {
        this.setName(name);
        this.addModifiers(modifiers);
    }

    public void addFieldType(String fieldType) {
       fieldTypes.add(fieldType);
    }

    public Collection<String> getFieldTypes() {
        return fieldTypes;
    }


    public ClassFile getOwningClass() {
        return owningClass;
    }

    public void setOwningClass(ClassFile owningClass) {
        this.owningClass = owningClass;
    }
}
