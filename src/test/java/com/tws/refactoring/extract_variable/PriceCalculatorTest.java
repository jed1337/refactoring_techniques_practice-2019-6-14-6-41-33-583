package com.tws.refactoring.extract_variable;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PriceCalculatorTest {
    @Test
    public void getPrice() {
        //given
        PriceCalculator priceCalculator = new PriceCalculator();
        //when
        double price = priceCalculator.getPrice(20, 30);
        //test
        assertThat(price, is(660.0));
    }

    @Test
    public void getPrice2() {
        //given
        PriceCalculator priceCalculator = new PriceCalculator();
        //when
        double price = priceCalculator.getPrice(25, 50);
        //test
        assertThat(price, is(1350.0));
    }
}
