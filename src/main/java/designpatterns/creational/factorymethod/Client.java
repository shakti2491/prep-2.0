package designpatterns.creational.factorymethod;

public class Client {
    public static void main(String[] args) {
        printMessage(new JsonMessageCreator());
    }

    private static void printMessage(MessageCreator messageCreator) {
        System.out.println(messageCreator.getMessage());
    }
}
