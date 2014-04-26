package reft;

import reft.migration.MigrationDriver;
import reft.model.ClassModelMap;
import reft.model.Migration;
import reft.processor.Java8Processor;
import reft.processor.MigrationController;
import reft.processor.MigrationTreePathScanner;
import org.junit.Test;
import reft.refactor.SourceChange;

import java.io.ByteArrayInputStream;
import java.util.*;

public class ScanningTests {

    @Test
    public void test() {
        ClassModelMap model = new ClassModelMap();
        Collection<Migration> migrations = Collections.emptyList();
        List<SourceChange> changes = new ArrayList<>();

        MigrationDriver analyzer = new MigrationDriver(migrations, changes);
        MigrationController controller = new MigrationController(Arrays.asList(new Java8Processor(new MigrationTreePathScanner(model, analyzer))));
        controller.migrate(Arrays.asList("test/project/org/Console.java"));
    }

}
