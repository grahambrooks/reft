package reft.common.model;

public interface Location {

    int getStartOffset();

    int getEndOffset();
    
    long getLineNumber();
}
