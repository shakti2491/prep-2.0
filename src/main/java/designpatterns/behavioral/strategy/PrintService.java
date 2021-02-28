package designpatterns.behavioral.strategy;

import java.util.List;

public class PrintService {

    private OrderPrinter printer;
    public PrintService(OrderPrinter printer){
        this.printer = printer;
    }

    public void printOrders(List<Order> orders){
        this.printer.print(orders);
    }
}
