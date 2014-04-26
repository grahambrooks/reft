package reft.refactor;

import reft.model.QualifiedName;
import reft.model.LocationInfo;
import reft.model.MethodInvocation;
import reft.model.predicate.MethodInvocationPredicate;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RenameMethodInvocationTests {
    @Test
    public void noCodeChangeIfPredicateDoesNotMatch() {
        MethodInvocationPredicate testing = new MethodInvocationPredicate("com.example.Text", "testing");
        RenameMethodInvocation renameMethodInvocation = new RenameMethodInvocation(testing, new QualifiedName("foo"));

        LocationInfo nameLocation = new LocationInfo();

        MethodInvocation invocation = new MethodInvocation(new QualifiedName("org.example.Text.testing"), nameLocation, Collections.emptyList());

        ArrayList<SourceChange> changes = new ArrayList<SourceChange>();

        renameMethodInvocation.apply(invocation, changes);

        assertThat(changes.size(), is(0));
    }

    @Test
    public void codeChangeOnMatchingPredicate() {
        MethodInvocationPredicate testing = new MethodInvocationPredicate("com.example.Text", "testing");
        RenameMethodInvocation renameMethodInvocation = new RenameMethodInvocation(testing, new QualifiedName("testMe"));

        LocationInfo nameLocation = new LocationInfo();
        nameLocation.setLineNumber(200);

        MethodInvocation invocation = new MethodInvocation(new QualifiedName("com.example.Text.testing"), nameLocation, Collections.emptyList());

        ArrayList<SourceChange> changes = new ArrayList<SourceChange>();

        renameMethodInvocation.apply(invocation, changes);

        assertThat(changes.size(), is(1));

        assertThat(changes.get(0).getLocation().getLineNumber(), is(nameLocation.getLineNumber()));
        assertThat(((ReplaceSourceChange)changes.get(0)).getReplacement(), is("testMe"));
    }
}
