package reft.common;


import java.util.*;

import static com.googlecode.totallylazy.Sequences.sequence;

public class QualifiedName {
    public enum Match {
        FULL, NONE, PARTIAL
    }

    private List<String> qualification = new ArrayList<>();
    private String name;

    public QualifiedName(String name) {
        this(Collections.emptyList(), name);
    }

    public QualifiedName(Collection<String> qualification, String name) {
        String[] names = name.split("\\.");

        this.qualification.addAll(qualification);

        this.qualification.addAll(Arrays.asList(names).subList(0, names.length - 1));
        this.name = names[names.length - 1];
    }

    public QualifiedName(String qualification, String name) {
        this(Arrays.asList(qualification.split("\\.")), name);
    }

    @Override
    public String toString() {
        if (qualification.size() > 0) {
            String qualificationString = sequence(qualification).foldLeft("", (s, e) -> s.equals("") ? e : s + "." + e);

            return qualificationString + '.' + name;
        } else return name;
    }

    public Match match(QualifiedName other) {
        if (name.equals(other.name)) {
            if (!isQualified() || !other.isQualified()) {
                if (!isQualified() && !other.isQualified()) {
                    return Match.FULL;
                } else {
                    return Match.PARTIAL;
                }
            } else {
                if (isQualified() && other.isQualified()) {
                    if (qualification.size() == other.qualification.size()) {
                        for (int i = 0; i < qualification.size(); i++) {
                            if (!qualification.get(i).equals(other.qualification.get(i))) {
                                return Match.NONE;
                            }
                        }
                    } else {
                        return Match.NONE;
                    }
                }
                return Match.FULL;
            }
        }
        return Match.NONE;
    }

    private boolean isQualified() {
        return qualification.size() != 0;
    }
}
