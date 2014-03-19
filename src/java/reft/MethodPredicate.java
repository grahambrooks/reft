package reft;

import reft.common.QualifiedName;
import reft.common.model.ClassFile;
import reft.common.model.MethodDeclaration;
import reft.common.model.MethodInvocationPredicate;

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
