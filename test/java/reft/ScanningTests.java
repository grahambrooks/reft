package reft;

import reft.common.MigrationDriver;
import reft.common.model.ClassModelMap;
import reft.processor.Java8Processor;
import reft.processor.MigrationController;
import reft.processor.MigrationTreePathScanner;
import org.junit.Test;

import java.util.Arrays;

public class ScanningTests {

    @Test
    public void test() {
        ClassModelMap model = new ClassModelMap();
        MigrationDriver analyzer = new MigrationDriver(model);
        MigrationController controller = new MigrationController(Arrays.asList(new Java8Processor(new MigrationTreePathScanner(model, analyzer))));
        controller.migrate(Arrays.asList("test/project/org/Main.java"));

    }

}
