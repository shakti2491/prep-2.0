package designpatterns.behavioral.strategy;

import java.util.Collection;
import java.util.Iterator;

public class SummaryPrinter implements OrderPrinter{
    @Override
    public void print(Collection<Order> orders) {
        System.out.println("************************Summary Report*************************");
        Iterator<Order> iterator = orders.iterator();
        int i = 1;
        while (iterator.hasNext()){
            Order order = iterator.next();
            System.out.println();
        }
    }
}
