package designpatterns.behavioral.templatemethod;

import designpatterns.behavioral.state.Order;

import java.io.IOException;
import java.io.PrintWriter;

public abstract class OrderPrinter {
    public void printOrder(Order order, String fileName) throws IOException {
        try(PrintWriter writer = new PrintWriter(fileName)){
            writer.println(start());
            writer.println(formatOrderNumber(order));
            writer.println(formatItems(order));
            writer.println(formatTotal(order));
            writer.println(end());
        }
    }

    protected abstract String start();

    protected  abstract String formatOrderNumber(Order order);

    protected abstract String formatItems(Order order);

    protected abstract String formatTotal(Order order);

    protected abstract String end();
}
