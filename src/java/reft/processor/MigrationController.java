package reft.processor;

import javax.annotation.processing.AbstractProcessor;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static com.googlecode.totallylazy.Sequences.sequence;

public class MigrationController {
    private final Iterable<AbstractProcessor> processors;


    public MigrationController(Iterable<AbstractProcessor> processors) {
        this.processors = processors;
    }

    public void migrate(Iterable<String> fileNames) {

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);

        List<File> files = getFilesAsList(fileNames);
        sequence(files).each((file) -> {

            Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(files);

            CompilationTask task = compiler.getTask(null, fileManager, null, null, null, compilationUnits);

            task.setProcessors(processors);

            task.call();
            try {
                fileManager.close();
            } catch (IOException e) {
                System.out.println(e.getLocalizedMessage());
            }
            return 0;
        });
    }

    private List<File> getFilesAsList(Iterable<String> fileNames) {
        return sequence(fileNames).foldLeft(new LinkedList<>(), (files, fileName) -> {
            File sourceFile = new File(fileName);
            if (sourceFile.exists()) {
                files.add(sourceFile);
            } else {
                System.out.println(fileName + " does not exist (Ignored)");
            }
            return files;
        });
    }
}
