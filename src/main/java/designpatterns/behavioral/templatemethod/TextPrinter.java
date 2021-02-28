package designpatterns.behavioral.templatemethod;

import designpatterns.behavioral.state.Order;

public class TextPrinter extends OrderPrinter{
    @Override
    protected String start() {
        return null;
    }

    @Override
    protected String formatOrderNumber(Order order) {
        return null;
    }

    @Override
    protected String formatItems(Order order) {
        return null;
    }

    @Override
    protected String formatTotal(Order order) {
        return null;
    }

    @Override
    protected String end() {
        return null;
    }
}
