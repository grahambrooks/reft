package reft;

import reft.migration.MigrationDriver;
import reft.model.ClassModelMap;
import reft.processor.Java8Processor;
import reft.processor.MigrationController;
import reft.processor.MigrationTreePathScanner;
import org.junit.Test;

import java.util.Arrays;

public class ScanningTests {

    @Test
    public void test() {
        ClassModelMap model = new ClassModelMap();
        MigrationDriver analyzer = new MigrationDriver();
        MigrationController controller = new MigrationController(Arrays.asList(new Java8Processor(new MigrationTreePathScanner(model, analyzer))));
        controller.migrate(Arrays.asList("test/project/org/Console.java"));

    }

}
