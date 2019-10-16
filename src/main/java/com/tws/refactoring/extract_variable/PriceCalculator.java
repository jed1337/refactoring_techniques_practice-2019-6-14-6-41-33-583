package com.tws.refactoring.extract_variable;

public class PriceCalculator {
    private static final double DISCOUNT_RATE = 0.05;
    private static final double SHIPPING_COST_PER_ITEM = 0.1;
    private static final double MAXIMUM_SHIPPING_COST = 100.0;

    double getPrice(int quantity, int itemPrice) {
        double basePrice = quantity * itemPrice;
        double discount = Math.max(0, quantity - 500) * itemPrice * DISCOUNT_RATE;
        double shippingCost = Math.min(quantity * itemPrice * SHIPPING_COST_PER_ITEM, MAXIMUM_SHIPPING_COST);

        return basePrice - discount + shippingCost;
    }
}
