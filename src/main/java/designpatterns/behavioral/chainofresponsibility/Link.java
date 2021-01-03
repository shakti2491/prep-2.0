package designpatterns.behavioral.chainofresponsibility;

public class Link implements ChainOfResponsibility{
    private ChainOfResponsibility delegate;
    public void perform() {
        System.out.println("Starting chain");
        delegate.perform();
        System.out.println("Ending chain");
    }
}
