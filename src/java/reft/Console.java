package reft;

import java.util.Arrays;
import java.util.List;

public class Console {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java reft.Console <migration-file> <files>");
            System.exit(0);
        } else {
            final List<String> filenames = Arrays.asList(args);

            String migrationFilename = filenames.get(0);
            filenames.remove(0);

            Application application = new Application();

            application.run(migrationFilename, filenames);
        }
    }
}
