package reft;

import reft.common.model.AnnotatedName;

public interface Migration {
    void apply(AnnotatedName model);
}
