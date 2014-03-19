package reft.common.model;

import java.util.HashMap;
import java.util.Map;

public class ClassModelMap {
    private Map<String, ClassFile> nameMap = new HashMap<String, ClassFile>();

    public ClassModelMap() {
    }

    public ClassFile getClassInfo(String className) {
        return nameMap.get(className);
    }

    public void addClassInfo(String className, ClassFile classInfo) {
        nameMap.put(className, classInfo);
    }
}
