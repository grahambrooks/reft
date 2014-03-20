package reft.processor;

import com.sun.source.util.TreePath;
import com.sun.source.util.Trees;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("*")
public class Java8Processor extends AbstractProcessor {
    private Trees trees;
    private final JavaScanner scanner;

    public Java8Processor(JavaScanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void init(ProcessingEnvironment pe) {
        super.init(pe);
        trees = Trees.instance(pe);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {

        for (Element e : roundEnvironment.getRootElements()) {
            TreePath tp = trees.getPath(e);

            scanner.scan((TypeElement) e, tp, trees);
        }

        return true;
    }

}
