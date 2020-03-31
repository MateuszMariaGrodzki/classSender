package serviceTests;

import service.MessageProvider;

public class MessageProviderTest {

    public static void main(String[] args) {
        String message = MessageProvider.getMessage("src/main/java/classRepository/HelloWorld.java");
        System.out.println(message);
    }
}
