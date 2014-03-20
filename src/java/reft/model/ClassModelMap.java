package reft.model;

import java.util.HashMap;
import java.util.Map;

public class ClassModelMap {
    private final Map<String, ClassFile> nameMap = new HashMap<>();

    public ClassModelMap() {
    }

    public ClassFile getClassInfo(String className) {
        return nameMap.get(className);
    }

    public void addClassInfo(String className, ClassFile classInfo) {
        nameMap.put(className, classInfo);
    }
}
