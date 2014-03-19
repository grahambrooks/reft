package reft.common.model;

import java.util.Collection;

public interface AnnotatedName {

    String getName();
        
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
