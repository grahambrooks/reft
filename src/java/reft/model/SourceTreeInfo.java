package reft.model;

import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.tree.Tree;
import com.sun.source.util.SourcePositions;


class SourceTreeInfo {

    private Tree tree = null;
    private CompilationUnitTree compileTree = null;
    private SourcePositions sourcePos = null;

    public CompilationUnitTree getCompileTree() {
        return compileTree;
    }

    public void setCompileTree(CompilationUnitTree compileTree) {
        this.compileTree = compileTree;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    public SourcePositions getSourcePos() {
        return sourcePos;
    }

    public void setSourcePos(SourcePositions sourcePos) {
        this.sourcePos = sourcePos;
    }
}
