package servlets.modelfortests;

public class MessageUtil {

    private String message;

    public MessageUtil(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
        int a = 0;
        int b = 1 / a;
        System.out.println(b);
    }

    public String salutationMessage() {
        message = "Hi!" + message;
        System.out.println(message);
        return message;
    }
}
