package com.tws.refactoring.extract_method;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class OwingPrinterTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void printBannerHeader() {
        //given
        String header = "*****************************" + LINE_SEPARATOR +
                        "****** Customer totals ******" + LINE_SEPARATOR +
                        "*****************************" + LINE_SEPARATOR;
        //when
        OwingPrinter printOwing = new OwingPrinter();
        printOwing.printOwing("Jed", Collections.emptyList());

        //then
        assertTrue(outContent.toString().contains(header));
    }

    @Test
    public void printBannerContentWithOneOrder() {
        //given
        String content = "name: Jed" + LINE_SEPARATOR+
                "amount: 5.0" + LINE_SEPARATOR;
        //when
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(5));

        OwingPrinter printOwing = new OwingPrinter();
        printOwing.printOwing("Jed", orders);

        //then
        assertTrue(outContent.toString().contains(content));
    }

    @Test
    public void printBannerContentWithThreeOrder() {
        //given
        String content = "name: Jed" + LINE_SEPARATOR+
                "amount: 25.0" + LINE_SEPARATOR;
        //when
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(5));
        orders.add(new Order(10));
        orders.add(new Order(10));

        OwingPrinter printOwing = new OwingPrinter();
        printOwing.printOwing("Jed", orders);

        //then
        assertTrue(outContent.toString().contains(content));
    }
}
