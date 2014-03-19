package reft.model;

import javax.lang.model.element.NestingKind;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DefaultJavaClassDeclaration extends DefaultAnnotatedName implements ClassFile {

    private String nameOfSuperClass;
    private String packageName;
    private String nestingKind;
    private boolean isInterface;
    private boolean isSerializable;
    private DefaultJavaSourceTree sourceTreeInfo;
    private Collection<MethodDeclaration> methodDeclarations = new ArrayList<>();
    private Collection<MethodDeclaration> constructors = new ArrayList<>();
    private Collection<String> nameOfInterfaces = new ArrayList<>();
    private Collection<String> classTypes = new ArrayList<>();
    private Map<QualifiedName, FieldDeclaration> fields = new HashMap<>();

    public void addField(FieldDeclaration fieldDeclaration) {
        fields.put(fieldDeclaration.getName(), fieldDeclaration);
    }

    public FieldDeclaration getField(String fieldName) {
        return fields.get(fieldName);
    }

    public void setFields(Map<QualifiedName, FieldDeclaration> fields) {
        this.fields = fields;
    }

    public Collection<FieldDeclaration> getFields() {
        return fields.values();
    }

    public void setNameOfSuperClass(String superClass) {
        this.nameOfSuperClass = superClass;
    }

    public String getNameOfSuperClass() {
        return this.nameOfSuperClass;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getNestingKind() {
        return nestingKind;
    }

    public void setNestingKind(String nestingKind) {
        this.nestingKind = nestingKind;
    }

    public void setSourceTreeInfo(DefaultJavaSourceTree sourceTreeInfo) {
        this.sourceTreeInfo = sourceTreeInfo;
    }

    public DefaultJavaSourceTree getSourceTreeInfo() {
        return this.sourceTreeInfo;
    }

    public Collection<MethodDeclaration> getMethodDeclarations() {
        return this.methodDeclarations;
    }

    public void setMethodDeclarations(Collection<MethodDeclaration> methodDeclarations) {
        this.methodDeclarations = methodDeclarations;
    }

    public void addMethod(MethodDeclaration methodDeclaration) {
        methodDeclarations.add(methodDeclaration);
    }

    public Collection<MethodDeclaration> getConstructors() {
        return constructors;
    }

    public void setConstructors(Collection<MethodDeclaration> constructors) {
        this.constructors = constructors;
    }

    public void addConstructor(MethodDeclaration methodDeclaration) {
        constructors.add(methodDeclaration);
    }

    public Collection<String> getNameOfInterfaces() {
        return nameOfInterfaces;
    }

    public void setNameOfInterfaces(Collection<String> interfaces) {
        this.nameOfInterfaces = interfaces;
    }

    public void addNameOfInterface(String interfaceDet) {
        this.nameOfInterfaces.add(interfaceDet);
    }

    public Collection<String> getClassTypes() {
        return classTypes;
    }

    public void setClassTypes(Collection<String> classTypes) {
        this.classTypes = classTypes;
    }

    public void addClassType(String classType) {
        this.classTypes.add(classType);
    }

    public boolean isInterface() {
        return this.isInterface;
    }

    public void setIsInterface(boolean interfaceFlag) {
        this.isInterface = interfaceFlag;
    }

    public void setSerializable(boolean isSerializable) {
        this.isSerializable = isSerializable;
    }

    public boolean isSerializable() {
        return isSerializable;
    }

    public boolean isTopLevelClass() {
        return nestingKind.equals(NestingKind.TOP_LEVEL.toString());
    }
}
