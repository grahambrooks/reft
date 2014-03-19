package reft.model.predicate;

import reft.model.Migration;
import reft.model.QualifiedName;
import reft.model.ClassFile;
import reft.model.MethodDeclaration;

public class MethodPredicate {
    QualifiedName name;

    public MethodPredicate(String name) {
        this.name = new QualifiedName(name);
    }

    public void test(ClassFile clazzInfo, Migration migration) {
        for (MethodDeclaration methodDeclaration : clazzInfo.getMethodDeclarations()) {

            if (name.equals(methodDeclaration.getName())) {
                migration.apply(methodDeclaration);
            }
        }
    }

    public boolean matches(MethodInvocationPredicate invocation) {
        return name.match(invocation.getQualifiedName()) != QualifiedName.Match.NONE;
    }
}
