package service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class MessageProvider {

    public static String getMessage(String pathToClass){
        String message = "<pre>";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToClass))){
            String currentLine = bufferedReader.readLine();
            while(currentLine != null){
                message += currentLine + "&#10;";
                currentLine = bufferedReader.readLine();
            }
        } catch(FileNotFoundException e){
            System.out.println("Błędna ścieżka do klasy");
        } catch(IOException ex){
            ex.printStackTrace();
        }
        message += "</pre>";
        return message;
    }

    public static String getMessageByPackage(String pathToPackage, String packageName) throws Exception{
        List<String> classNames = ClassListProvider.getClassNamesByPackageName(
                ClassListProvider.class.getClassLoader(),packageName);
        String message = "<h1>W pakiecie " + packageName + " znajdują się " + classNames.size() + "klasy</h1><br>";
        for(String string : classNames){
            message += getMessage(pathToPackage + packageName + string + ".java");
        }
        return message;
    }
}
