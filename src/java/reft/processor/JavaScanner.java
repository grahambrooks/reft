package reft.processor;

import com.sun.source.util.TreePath;
import com.sun.source.util.Trees;

import javax.lang.model.element.TypeElement;

public interface JavaScanner {

    public void scan(TypeElement e, TreePath tp, Trees trees);
}
