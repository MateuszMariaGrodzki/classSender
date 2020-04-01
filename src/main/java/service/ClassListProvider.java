package service;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ClassListProvider {

    public static List<String> getClassNamesByPackageName(ClassLoader classLoader, String packageName) throws Exception {
        String dottedPackage = packageName.replaceAll("/",".");
        List<String> classNames = new ArrayList<>();
        URL upackage = classLoader.getResource(packageName);
        DataInputStream dataInputStream = new DataInputStream((InputStream) upackage.getContent());
        String line = null;
        String className = "";
        while ((line = dataInputStream.readLine()) != null) {
            if (line.endsWith(".class")) {
                className = Class.forName(dottedPackage+ "." + line.substring(0, line.lastIndexOf('.'))).getName();
                classNames.add(className.substring(className.lastIndexOf(".") +1));
            }
        }
        return classNames;
    }
}
