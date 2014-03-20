package reft.migration;

import reft.model.QualifiedName;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

import static com.googlecode.totallylazy.Sequences.sequence;

class MigrationReader {

    private QualifiedName buildQualifiedName(List<TerminalNode> elements) {
        String name = sequence(elements).last().getText();
        List<String> qualification = sequence(elements).take(elements.size() - 1).foldLeft(new ArrayList<>(), (set, element) -> {
            set.add(element.getText());
            return set;
        });
        return new QualifiedName(qualification, name);
    }

}
