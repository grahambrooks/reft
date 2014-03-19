package reft.migration.model;

import reft.common.QualifiedName;
import com.googlecode.totallylazy.Arrays;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class QualifiedNameTests {
    @Test
    public void acceptsSimpleNames() {
        QualifiedName q = new QualifiedName("foo");

        assertThat(q.toString(), is("foo"));
    }

    @Test
    public void comparingQualifiedAndUnqualifiedResultsInPartialMatch() {
        QualifiedName q1 = new QualifiedName("foo");
        QualifiedName q2 = new QualifiedName(Arrays.list("com", "example"), "foo");

        assertThat(q1.match(q2), is(QualifiedName.Match.PARTIAL));
        assertThat(q2.match(q1), is(QualifiedName.Match.PARTIAL));
    }

    @Test
    public void matchesForSimpleNames() {
        QualifiedName q1 = new QualifiedName("foo");
        QualifiedName q2 = new QualifiedName("foo");

        assertThat(q1.match(q2), is(QualifiedName.Match.FULL));
        assertThat(q2.match(q1), is(QualifiedName.Match.FULL));
    }

    @Test
    public void matchesForLongerNames() {
        QualifiedName q1 = new QualifiedName("com.example.foo");
        QualifiedName q2 = new QualifiedName("com.example.foo");

        assertThat(q1.match(q2), is(QualifiedName.Match.FULL));
        assertThat(q2.match(q1), is(QualifiedName.Match.FULL));
    }

    @Test
    public void matchFailsWithDifferentQualifiers() {
        QualifiedName q1 = new QualifiedName("org.example.foo");
        QualifiedName q2 = new QualifiedName("com.example.foo");

        assertThat(q1.match(q2), is(QualifiedName.Match.NONE));
        assertThat(q2.match(q1), is(QualifiedName.Match.NONE));
    }
    @Test
    public void matchFailsWithDifferentNames() {
        QualifiedName q1 = new QualifiedName("org.example.foo");
        QualifiedName q2 = new QualifiedName("org.example.bar");

        assertThat(q1.match(q2), is(QualifiedName.Match.NONE));
        assertThat(q2.match(q1), is(QualifiedName.Match.NONE));
    }
}
