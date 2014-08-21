package reft;

import reft.model.Location;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class StreamEditor {
    private InputStream inputStream;
    private Change[] changes;

    public interface Change {
        boolean applicable(int offset);

        void apply(InputStream input, OutputStream output);
    }

    static class Deletion implements Change {
        private Location location;

        public Deletion(Location location) {

            this.location = location;
        }

        @Override
        public boolean applicable(int offset) {
            return offset == location.getStartOffset();
        }

        @Override
        public void apply(InputStream input, OutputStream output) {
            try {
                int skip = location.getEndOffset() - location.getStartOffset();

                while (skip > 0) {
                    input.read();
                    skip--;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class Replacement extends Deletion {

        private String replacement;

        public Replacement(Location location, String replacement) {
            super(location);
            this.replacement = replacement;
        }

        @Override
        public void apply(InputStream input, OutputStream output) {
            try {
                super.apply(input, output);
                output.write(replacement.getBytes(Charset.defaultCharset()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Change deletion(Location location) {
        return new Deletion(location);
    }

    public static Change replacement(Location location, String replacement) {
        return new Replacement(location, replacement);
    }

    public StreamEditor(InputStream inputStream, Change... changes) {

        this.inputStream = inputStream;
        this.changes = changes;
    }

    public void edit(OutputStream output) {
        try {
            int offset = 0;
            int r;
            while (true) {
                modifications(offset, inputStream, output);

                r = inputStream.read();
                if (r == -1) {
                    break;
                }
                output.write(r);
                offset += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void modifications(int offset, InputStream inputStream, OutputStream output) {
        for (Change l : changes) {
            if (l.applicable(offset)) {
                l.apply(inputStream, output);
            }
        }
    }
}
