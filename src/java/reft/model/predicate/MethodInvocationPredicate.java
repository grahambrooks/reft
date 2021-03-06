package reft.model.predicate;

import reft.model.MethodInvocation;
import reft.model.QualifiedName;

public class MethodInvocationPredicate {
    private final QualifiedName qualifiedName;

    public MethodInvocationPredicate(String className, String methodName) {
        this.qualifiedName = new QualifiedName(className, methodName);
    }
    public MethodInvocationPredicate(QualifiedName qualifiedName) {
        this.qualifiedName = qualifiedName;
    }

    public QualifiedName getQualifiedName() {
        return qualifiedName;
    }

    public boolean matches(MethodInvocation methodInvocation) {

        return qualifiedName.match(methodInvocation.getName()) != QualifiedName.Match.NONE;
    }

    @Override
    public String toString() {
        return qualifiedName + "()";
    }
}
