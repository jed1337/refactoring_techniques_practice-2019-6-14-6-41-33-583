package com.tws.refactoring.extract_method;

import java.util.Iterator;
import java.util.List;

public class OwingPrinter {
    void printOwing(String name, List<Order> orders) {
        Iterator<Order> elements = orders.iterator();

        printHeader();
        printDetails(name, elements);
    }

    void printHeader() {
        System.out.println("*****************************");
        System.out.println("****** Customer totals ******");
        System.out.println("*****************************");
    }

    double printOwings(Iterator<Order> elements) {
        double outstanding = 0.0;

        while (elements.hasNext()) {
            Order each = (Order) elements.next();
            outstanding += each.getAmount();
        }
        return outstanding;
    }

    void printDetails(String name, Iterator<Order> elements) {
        System.out.println("name: " + name);
        System.out.println("amount: " + printOwings(elements));
    }
}

class Order {
    private final double amount;

    public Order(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
