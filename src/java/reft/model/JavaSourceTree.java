package reft.model;

import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.tree.Tree;
import com.sun.source.util.SourcePositions;

public interface JavaSourceTree {
    
    CompilationUnitTree getCompileTree();
    
    Tree getTree();
    
    SourcePositions getSourcePos();

}
