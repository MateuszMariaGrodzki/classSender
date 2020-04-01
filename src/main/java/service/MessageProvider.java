package service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
}
