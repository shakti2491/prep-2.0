package designpatterns.behavioral.observer;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Order {

    private String id;

    private double itemCost;

    private int count;

    private List<OrderObserver> observers;

    void notifi(){
        observers.forEach(observer -> observer.updated(this));
    }

    public void attach(OrderObserver orderObserver){
        observers.add(orderObserver);
    }

    public void detach(OrderObserver orderObserver){
        observers.remove(orderObserver);
    }

    void addCost(int x){

        notifi();
    }
}
