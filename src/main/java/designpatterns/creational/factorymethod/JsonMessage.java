package designpatterns.creational.factorymethod;

public class JsonMessage extends Message{
    @Override
    public String getContent() {
        return "{\"JSON]\":[]}";
    }
}
