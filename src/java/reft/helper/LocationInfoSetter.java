package reft.helper;

import com.sun.source.tree.CompilationUnitTree;
import reft.model.DefaultJavaClassDeclaration;
import reft.model.FieldDeclaration;
import reft.model.LocationInfo;
import reft.model.MethodDeclaration;

import javax.tools.JavaFileObject;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LocationInfoSetter {

    public static void setLocationInfoForElements(DefaultJavaClassDeclaration clazzInfo) {
        try {

            CompilationUnitTree compileTree = clazzInfo.getSourceTreeInfo().
                    getCompileTree();

            JavaFileObject file = compileTree.getSourceFile();
            String javaFileContent = file.getCharContent(true).toString();

            CharBuffer buffer = getCharacterBufferOfSource(javaFileContent);

            setLocInfoOfClass(clazzInfo, buffer, compileTree);
            setLocInfoOfConstructors(clazzInfo, buffer, compileTree);
            setLocInfoOfMethods(clazzInfo, buffer, compileTree);
            setLocInfoOfVariables(clazzInfo, buffer, compileTree);
        } catch (IOException ex) {
            Logger.getLogger(LocationInfoSetter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Converts the java file content to character buffer
     *
     * @param javaFile Content of java file being processed
     * @return Character buffer representation of the java source file
     */
    private static CharBuffer getCharacterBufferOfSource(String javaFile) {
        CharBuffer charBuffer = CharBuffer.wrap(javaFile.toCharArray());
        return charBuffer;
    }

    private static void setLocInfoOfClass(DefaultJavaClassDeclaration clazzInfo,
                                          CharBuffer buffer, CompilationUnitTree compileTree) {
        String clazzName = clazzInfo.getName().getName();
        LocationInfo clazzNameLoc = (LocationInfo) clazzInfo.getLocationInfo();
        int startIndex = clazzNameLoc.getStartOffset();
        int endIndex = -1;
        if (startIndex >= 0) {
            String strToSearch = buffer.subSequence(startIndex,
                    buffer.length()).toString();
            Pattern p = Pattern.compile(clazzName);
            Matcher matcher = p.matcher(strToSearch);
            matcher.find();
            startIndex = matcher.start() + startIndex;
            endIndex = startIndex + clazzName.length();
        }
        clazzNameLoc.setStartOffset(startIndex);
        clazzNameLoc.setEndOffset(endIndex);
        clazzNameLoc.setLineNumber(compileTree.getLineMap().
                getLineNumber(startIndex));
    }


    private static void setLocInfoOfConstructors(DefaultJavaClassDeclaration clazzInfo,
                                                 CharBuffer buffer, CompilationUnitTree compileTree) {
        for (MethodDeclaration methodDeclaration : clazzInfo.getConstructors()) {
            LocationInfo constructorNameLoc = (LocationInfo)
                    methodDeclaration.getLocationInfo();
            int startIndex = constructorNameLoc.getStartOffset();
            int endIndex = -1;
            if (startIndex >= 0) {
                String strToSearch = buffer.subSequence(startIndex,
                        buffer.length()).toString();
                Pattern p = Pattern.compile(methodDeclaration.getName().toString());
                Matcher matcher = p.matcher(strToSearch);
                matcher.find();
                startIndex = matcher.start() + startIndex;
                endIndex = startIndex + methodDeclaration.getName().toString().length();
            }
            constructorNameLoc.setStartOffset(startIndex);
            constructorNameLoc.setEndOffset(endIndex);
            constructorNameLoc.setLineNumber(compileTree.getLineMap().
                    getLineNumber(startIndex));
        }
    }

    private static void setLocInfoOfMethods(DefaultJavaClassDeclaration clazzInfo, CharBuffer buffer, CompilationUnitTree compileTree) {
        for (MethodDeclaration methodDeclaration : clazzInfo.getMethodDeclarations()) {
            LocationInfo methodNameLoc = (LocationInfo) methodDeclaration.getLocationInfo();
            int startIndex = methodNameLoc.getStartOffset();
            int endIndex = -1;
            if (startIndex >= 0) {
                String strToSearch = buffer.subSequence(startIndex, buffer.length()).toString();
                Pattern p = Pattern.compile(methodDeclaration.getName().toString());
                Matcher matcher = p.matcher(strToSearch);
                matcher.find();
                startIndex = matcher.start() + startIndex;
                endIndex = startIndex + methodDeclaration.getName().toString().length();
            }
            methodNameLoc.setStartOffset(startIndex);
            methodNameLoc.setEndOffset(endIndex);
            methodNameLoc.setLineNumber(compileTree.getLineMap().getLineNumber(startIndex));
        }
    }

    private static void setLocInfoOfVariables(DefaultJavaClassDeclaration clazzInfo, CharBuffer buffer, CompilationUnitTree compileTree) {
        for (FieldDeclaration fieldDeclaration : clazzInfo.getFields()) {
            LocationInfo methodNameLoc = (LocationInfo) fieldDeclaration.getLocationInfo();
            int startIndex = methodNameLoc.getStartOffset();
            int endIndex = -1;
            if (startIndex >= 0) {
                String strToSearch = buffer.subSequence(startIndex, buffer.length()).toString();
                Pattern p = Pattern.compile(fieldDeclaration.getName().toString());
                Matcher matcher = p.matcher(strToSearch);
                matcher.find();
                startIndex = matcher.start() + startIndex;
                endIndex = startIndex + fieldDeclaration.getName().toString().length();
            }
            methodNameLoc.setStartOffset(startIndex);
            methodNameLoc.setEndOffset(endIndex);
            methodNameLoc.setLineNumber(compileTree.getLineMap().getLineNumber(startIndex));
        }
    }
}
