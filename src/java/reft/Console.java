package reft;

import reft.migration.MigrationDriver;
import reft.model.ClassModelMap;
import reft.processor.Java8Processor;
import reft.processor.MigrationController;
import reft.processor.MigrationTreePathScanner;

import java.util.Arrays;

public class Console {

    public static void main(String[] args) {
        try {

            if (args.length < 1) {
                System.out.println("Usage: java reft.Console <files>");
                System.exit(0);
            } else {
                ClassModelMap model = new ClassModelMap();
                MigrationDriver analyzer = new MigrationDriver(model);
                MigrationTreePathScanner scanner = new MigrationTreePathScanner(model, analyzer);
                Java8Processor processor = new Java8Processor(scanner);

                MigrationController controller = new MigrationController(Arrays.asList(processor));

                controller.migrate(Arrays.asList(args));
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
