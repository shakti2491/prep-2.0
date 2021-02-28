package designpatterns.behavioral.strategy;

import java.util.ArrayList;

public class Client {

    public static void main(String[] args) {
        PrintService printService = new PrintService(new SummaryPrinter());
        printService.printOrders(new ArrayList<>());
    }
}
