package reft.util;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import static com.googlecode.totallylazy.Sequences.sequence;

public class Signature {
    public static Signature empty = new Signature(0);

    int hash;

    public Signature(int hash) {
        this.hash = hash;
    }

    @Override
    public int hashCode() {
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Signature && hash == ((Signature) obj).hash;
    }

    @Override
    public String toString() {
        return "" + hash;
    }

    public static Signature fromTree(ParseTree tree) {
        Signature result = empty;

        if (tree != null) {
            if (tree.getPayload() != null) {
                if (tree.getPayload() instanceof Token) {
                    result = composite(result, fromString(((Token) tree.getPayload()).getText()));
                }
            }

            for (int i = 0; i < tree.getChildCount(); i++) {
                ParseTree child = tree.getChild(i);

                result = composite(result, fromTree(child));
            }
        }
        return result;
    }

    public static Signature fromString(String s) {
        return new Signature(s.hashCode());
    }

    public static Signature composite(Object... items) {
        return new Signature(sequence(items).foldLeft(0, (a, b) -> a + b.hashCode()));
    }

}
