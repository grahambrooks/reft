package reft.predicate;

import org.junit.Test;
import reft.MethodPredicate;
import reft.common.model.MethodInvocationPredicate;

import static org.junit.Assert.assertTrue;

public class MethodPredicateTests {
    @Test
    public void matchesMethodInvocationByName() {
        MethodInvocationPredicate invocation = new MethodInvocationPredicate("com.example.SomeClass", "SomeMethod");

        MethodPredicate predicate = new MethodPredicate("SomeMethod");

        assertTrue(predicate.matches(invocation));
    }

    @Test
    public void matchesMethodInvocationByQualifiedName() {
        MethodInvocationPredicate invocation = new MethodInvocationPredicate("com.example.SomeClass", "SomeMethod");

        MethodPredicate predicate = new MethodPredicate("com.example.SomeClass.SomeMethod");

        assertTrue(predicate.matches(invocation));
    }

}
