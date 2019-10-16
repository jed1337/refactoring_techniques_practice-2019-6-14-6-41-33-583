package com.tws.refactoring.extract_variable;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriceCalculatorTest {
    private PriceCalculator priceCalculator;

    @Before
    public void priceCalculator() {
        //given
        priceCalculator = new PriceCalculator();
    }

    @Test
    public void getPrice() {
        //when
        double price = priceCalculator.getPrice(20, 30);
        //test
        assertThat(price, is(660.0));
    }

    @Test
    public void getPrice2() {
        //when
        double price = priceCalculator.getPrice(25, 50);
        //test
        assertThat(price, is(1350.0));
    }

    @Test
    public void getDiscountWhenQuantityIsLessThanMinimumQuantityForDiscount() {
        double discount = priceCalculator.getDiscount(5, 100);
        assertThat(discount, is(0.0));
    }

    @Test
    public void getDiscountWhenQuantityIsGreaterThanMinimumQuantityForDiscount() {
        double discount = priceCalculator.getDiscount(1000, 1);
        assertThat(discount, is(25.0));
    }

    @Test
    public void getShippingCostWhenLessThanMaximumShippingCost() {
        double shippingCost = priceCalculator.getShippingCost(5, 10);
        assertThat(shippingCost, is(5.0));
    }

    @Test
    public void getShippingCostWhenGreaterThanMaximumShippingCost() {
        double shippingCost = priceCalculator.getShippingCost(5, 1000);
        assertThat(shippingCost, is(100.0));
    }
}
