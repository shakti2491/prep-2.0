package designpatterns.behavioral.observer;

public class PriceObserver implements OrderObserver{
    @Override
    public void updated(Order subject) {
        subject.getCount();
    }
}
