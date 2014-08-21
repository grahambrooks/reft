package reft;



import reft.refactor.SourceChange;
import java.io.ByteArrayOutputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class JavaTestProject {

    private final Path basePath;

    public static String containing(String template) {
        return template;
    }

    JavaTestProject() {

        try {
            this.basePath = Files.createTempDirectory("jtp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void cleanup() {
        try {
            removeRecursive(basePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void removeRecursive(Path path) throws IOException {
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                // try to deletion the file anyway, even if its attributes
                // could not be read, since deletion-only access is
                // theoretically possible
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                if (exc == null) {
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                } else {
                    // directory iteration failed; propagate exception
                    throw exc;
                }
            }
        });
    }

    public void withClass(String qualifiedName, String containing) {
        String[] segments = qualifiedName.split("\\.");

        segments[segments.length - 1] = segments[segments.length - 1] + ".java";

        Path filePath = basePath.getFileSystem().getPath(basePath.toString(), segments);

        Path directory = filePath.getParent();

        try {
            Files.createDirectories(directory);
            final Path file = Files.createFile(filePath);

            final BufferedWriter bufferedWriter = Files.newBufferedWriter(file, Charset.defaultCharset());

            bufferedWriter.write(containing);
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Iterable<String> files() {
        try {
            ArrayList<String> result = new ArrayList<>();

            Files.walkFileTree(basePath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    result.add(file.toString());
                    return FileVisitResult.CONTINUE;
                }
            });

            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void apply(List<SourceChange> changes) {
        try {
            StreamEditor.Change[] edits = new StreamEditor.Change[changes.size()];
            int i = 0;

            for (SourceChange c : changes) {
                edits[i] = c.toEditorChange();
                i++;
            }

            for (String filename : files()) {
                final FileInputStream input = new FileInputStream(filename);

                final ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();

                StreamEditor editor = new StreamEditor(input, edits);

                editor.edit(byteOutputStream);

                System.out.println(byteOutputStream.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public String file(String qualifiedName) {
        return "";
    }
}
