package reft;

import org.junit.Test;
import reft.model.Location;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static reft.StreamEditor.deletion;
import static reft.StreamEditor.replacement;

public class StreamEditorTests {

    class SimpleLocation implements Location {
        private int startOffset;
        private int endOffset;

        public SimpleLocation(int startOffset, int endOffset) {
            this.startOffset = startOffset;
            this.endOffset = endOffset;
        }

        @Override
        public int getStartOffset() {
            return startOffset;
        }

        @Override
        public int getEndOffset() {
            return endOffset;
        }

        @Override
        public long getLineNumber() {
            return 0;
        }
    }

    @Test
    public void writesNothingForEmptyStream() {
        final ByteArrayInputStream inputStream = new ByteArrayInputStream("".getBytes(Charset.defaultCharset()));

        StreamEditor editor = new StreamEditor(inputStream);
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        editor.edit(output);

        assertThat(output.toString(), is(""));
    }

    @Test
    public void copiesInputWithoutModificationWithNoEdits() {
        final ByteArrayInputStream inputStream = new ByteArrayInputStream("Hello World".getBytes(Charset.defaultCharset()));

        StreamEditor editor = new StreamEditor(inputStream);
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        editor.edit(output);

        assertThat(output.toString(), is("Hello World"));
    }

    @Test
    public void removesCharactersForDeleteChanges() {
        final ByteArrayInputStream inputStream = new ByteArrayInputStream("Hello World".getBytes(Charset.defaultCharset()));

        StreamEditor editor = new StreamEditor(inputStream, deletion(new SimpleLocation(5, 6)));
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        editor.edit(output);

        assertThat(output.toString(), is("HelloWorld"));
    }

    @Test
    public void removesCharactersAtStart() {
        final ByteArrayInputStream inputStream = new ByteArrayInputStream("Hello World".getBytes(Charset.defaultCharset()));

        StreamEditor editor = new StreamEditor(inputStream, deletion(new SimpleLocation(0, 1)));
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        editor.edit(output);

        assertThat(output.toString(), is("ello World"));
    }

    @Test
    public void removesCharactersAtEnd() {
        final ByteArrayInputStream inputStream = new ByteArrayInputStream("Hello World".getBytes(Charset.defaultCharset()));

        StreamEditor editor = new StreamEditor(inputStream, deletion(new SimpleLocation(10, 11)));
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        editor.edit(output);

        assertThat(output.toString(), is("Hello Worl"));
    }

    @Test
    public void replacementInsertsNewText() {
        final ByteArrayInputStream inputStream = new ByteArrayInputStream("Hello World".getBytes(Charset.defaultCharset()));

        StreamEditor editor = new StreamEditor(inputStream, replacement(new SimpleLocation(6, 6), "to the "));

        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        editor.edit(output);

        assertThat(output.toString(), is("Hello to the World"));

    }
    @Test
    public void replacementAddsTextToTheEnd() {
        final ByteArrayInputStream inputStream = new ByteArrayInputStream("Hello World".getBytes(Charset.defaultCharset()));

        StreamEditor editor = new StreamEditor(inputStream, replacement(new SimpleLocation(11, 11), "!"));

        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        editor.edit(output);

        assertThat(output.toString(), is("Hello World!"));

    }
    @Test
    public void replacementAddsTextToStart() {
        final ByteArrayInputStream inputStream = new ByteArrayInputStream("Hello World".getBytes(Charset.defaultCharset()));

        StreamEditor editor = new StreamEditor(inputStream, replacement(new SimpleLocation(0, 0), "Wow "));

        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        editor.edit(output);

        assertThat(output.toString(), is("Wow Hello World"));

    }
}
