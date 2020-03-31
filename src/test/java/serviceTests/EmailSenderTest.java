package serviceTests;

import service.EmailSender;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EmailSenderTest {

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        try(InputStream inputStream = new FileInputStream("src/main/resources/email.properties")) {
            properties.load(inputStream);
        } catch (IOException e){
            e.printStackTrace();
        }
        EmailSender.sendEmail(properties.getProperty("accountToSend"),"Test","Email testowy");
    }
}
