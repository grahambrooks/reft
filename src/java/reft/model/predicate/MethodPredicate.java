package reft.model.predicate;

import reft.model.ClassFile;
import reft.model.MethodDeclaration;
import reft.model.Migration;
import reft.model.QualifiedName;

public class MethodPredicate {
    private final QualifiedName name;

    public MethodPredicate(String name) {
        this.name = new QualifiedName(name);
    }

    public void test(ClassFile clazzInfo, Migration migration) {
        clazzInfo.getMethodDeclarations().stream().filter(methodDeclaration -> name.equals(methodDeclaration.getName())).forEach(migration::apply);
    }

    public boolean matches(MethodInvocationPredicate invocation) {
        return name.match(invocation.getQualifiedName()) != QualifiedName.Match.NONE;
    }
}
