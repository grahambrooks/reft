package reft.model;

import java.util.Collection;

public interface AnnotatedName {

    QualifiedName getName();
        
    Collection<Annotation> getAnnotations();

    boolean isPublic();

    boolean isProtected();

    boolean isFinal();
    
    boolean isNative();
    
    boolean isStatic();
    
    boolean isPrivate();
    
    boolean isAbstract();
    
    Location getLocationInfo();
}
