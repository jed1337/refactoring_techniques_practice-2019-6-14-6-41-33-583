package com.tws.refactoring.extract_variable;

public class PriceCalculator {
    private static final double DISCOUNT_RATE = 0.05;
    private static final double SHIPPING_COST_PER_ITEM = 0.1;
    private static final double MAXIMUM_SHIPPING_COST = 100.0;
    private static final int MINIMUM_QUANTITY_FOR_DISCOUNT = 500;

    double getPrice(int quantity, int itemPrice) {
        double basePrice = quantity * itemPrice;
        double discount = getDiscount(quantity, itemPrice);
        double shippingCost = getShippingCost(quantity, itemPrice);

        return basePrice - discount + shippingCost;
    }

    double getDiscount(int quantity, int itemPrice) {
        return Math.max(0, quantity - MINIMUM_QUANTITY_FOR_DISCOUNT) * itemPrice * DISCOUNT_RATE;
    }

    double getShippingCost(int quantity, int itemPrice) {
        return Math.min(quantity * itemPrice * SHIPPING_COST_PER_ITEM, MAXIMUM_SHIPPING_COST);
    }
}
