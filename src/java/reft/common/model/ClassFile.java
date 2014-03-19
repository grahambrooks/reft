package reft.common.model;

import java.util.Collection;


public interface ClassFile extends AnnotatedName {

    Collection<FieldDeclaration> getFields();

    FieldDeclaration getField(String fieldName);

    /**
     * @return all the methods that are present in this class. This includes
     *         methods that are added by compiler as well, e.g. clinit and init
     *         methods.
     */
    Collection<MethodDeclaration> getMethodDeclarations();

    /**
     * @param methodRef is the reference of the method that is being looked for
     * @return return the method object that matches the guven criteria. null,
     *         otherwise.
     */
    // MethodDeclaration getMethod(MethodRef methodRef);
    /**
     * @return external name of super class
     */
    String getNameOfSuperClass();

    /**
     * @return external names of any interfaces implemented by this class.
     */
    Collection<String> getNameOfInterfaces();

    /**
     * @return true if this is an interface, else false
     */
    boolean isInterface();

    boolean isSerializable();
    
    public boolean isTopLevelClass();

    Collection<MethodDeclaration> getConstructors();

    Collection<String> getClassTypes();

    DefaultJavaSourceTree getSourceTreeInfo();

    public void addClassType(String classType);

}
