package serviceTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.EmailSender;
import service.MessageProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EmailSenderTest {

    Properties properties;

    @BeforeEach
    public void init(){
        Properties properties = new Properties();
        try(InputStream inputStream = new FileInputStream("src/main/resources/email.properties")) {
            properties.load(inputStream);
        } catch (IOException e){
            e.printStackTrace();
        }
        this.properties = properties;
    }

    @Test
    @DisplayName("Test for sendingEmail by using getMessage")
    public void emailByGetMessageTest() throws Exception{
        EmailSender.sendEmail(properties.getProperty("accountToSend"),"Test",
                MessageProvider.getMessage("src/main/java/classRepository/HelloWorld.java"));
    }

    @Test
    @DisplayName("Test sending all classes in given package")
    public void emailByGetMessageByPackageTest() throws Exception {
        String message = MessageProvider.getMessageByPackage("src/main/java/", "classRepository");
        EmailSender.sendEmail(properties.getProperty("accountToSend"), "Test", message);
    }
}
