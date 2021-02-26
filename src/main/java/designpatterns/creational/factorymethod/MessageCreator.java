package designpatterns.creational.factorymethod;

public abstract class MessageCreator {
    public Message getMessage(){
        Message msg = createMessage();
        msg.addDefaultHeaders();
        msg.encrypt();
        return msg;
    }

    public abstract Message createMessage();
}
