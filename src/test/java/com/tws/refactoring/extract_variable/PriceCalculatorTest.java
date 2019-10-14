package com.tws.refactoring.extract_variable;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

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
}
