package reft;

import reft.migration.MigrationDriver;
import reft.migration.MigrationReader;
import reft.model.ClassModelMap;
import reft.model.Migration;
import reft.processor.Java8Processor;
import reft.processor.MigrationController;
import reft.processor.MigrationTreePathScanner;
import reft.refactor.SourceChange;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Application {
    public void run(String migrationFilename, List<String> filenames) {
        try {

            ClassModelMap model = new ClassModelMap();

            MigrationReader reader = new MigrationReader();

            Collection<Migration> migrations = reader.readMigrations(new FileInputStream(migrationFilename));

            List<SourceChange> changes = new ArrayList<>();


            MigrationDriver driver = new MigrationDriver(migrations, changes);
            MigrationTreePathScanner scanner = new MigrationTreePathScanner(model, driver);
            Java8Processor processor = new Java8Processor(scanner);

            MigrationController controller = new MigrationController(Arrays.asList(processor));

            controller.migrate(filenames);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
