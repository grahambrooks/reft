package reft.common.util;


public class CodeAnalyzerUtil {


    public static String getSimpleNameFromQualifiedName(String qualifiedName) {

        String simpleName = null;
        if (qualifiedName != null && qualifiedName.length() > 0) {
            simpleName = qualifiedName.substring(1 + qualifiedName.
                    lastIndexOf("."), qualifiedName.length());
        }
        return simpleName;
    }

}
