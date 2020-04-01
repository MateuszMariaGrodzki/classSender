package service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EmailSender {

    public static void sendEmail(String reciever, String subject, String content) throws Exception {
        System.out.println("Trwa wysyłanie wiadomości do " + reciever);
        Properties properties = new Properties();

        try(InputStream inputStream = new FileInputStream("src/main/resources/email.properties")) {
        properties.load(inputStream);
        } catch (IOException e){
            e.printStackTrace();
        }

        final String myAccount = properties.getProperty("myAccount");
        final String myPassword = properties.getProperty("myPassword");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccount,myPassword);
            }
        });

        Message message = createMessage(session, myAccount, reciever, subject, content );
        Transport.send(message);
        System.out.println("Wiadomość wysłana");
    }

    private static Message createMessage(Session session, String myAccount, String adress, String subject, String content) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccount));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(adress));
            message.setSubject(subject);
            message.setContent(content,"text/html");
            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
