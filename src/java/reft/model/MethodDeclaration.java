package reft.model;

import java.util.Collection;

public interface MethodDeclaration extends AnnotatedName {

    ClassFile getOwningClass();
    
    Collection<String> getExceptions();
 
    Collection<String> getParameters();
    
    String getReturnType();
    
}
