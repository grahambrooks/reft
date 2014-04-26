package reft;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import reft.migration.MigrationDriver;
import reft.migration.MigrationReader;
import reft.model.ClassModelMap;
import reft.model.Migration;
import reft.processor.Java8Processor;
import reft.processor.MigrationController;
import reft.processor.MigrationTreePathScanner;
import reft.refactor.SourceChange;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static reft.JavaTestProject.containing;

public class AcceptanceTests {

    private JavaTestProject testProject;

    @Before
    public void setup() {
        testProject = new JavaTestProject();
    }

    @After
    public void cleanup() {
        testProject.cleanup();
    }

    @Test
    public void simpleMethodCallRename() throws UnsupportedEncodingException {
        testProject.withClass("org.example.Main", containing("class Main {" +
                "   public void someMethod() {" +
                "      someAwesomeMethod();" +
                "   }" +
                "}"));

        String input = "migration someAwesomeMethod() -> someMoreAwesomeMethod();";

        MigrationReader reader = new MigrationReader();

        Collection<Migration> migrations = reader.readMigrations(new ByteArrayInputStream(input.getBytes("UTF-8")));

        List<SourceChange> changes = new ArrayList<>();

        ClassModelMap model = new ClassModelMap();
        MigrationDriver analyzer = new MigrationDriver(migrations, changes);
        MigrationTreePathScanner scanner = new MigrationTreePathScanner(model, analyzer);
        Java8Processor processor = new Java8Processor(scanner);
        MigrationController controller = new MigrationController(Arrays.asList(processor));

        // Apply changes to the project
        controller.migrate(testProject.files());

        testProject.apply(changes);

        assertThat(testProject.file("org.example.Main"), is(""));

    }
}
