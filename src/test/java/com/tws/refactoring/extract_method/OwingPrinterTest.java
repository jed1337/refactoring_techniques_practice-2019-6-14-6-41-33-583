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
        String header = "*****************************\r\n" +
                        "****** Customer totals ******\r\n" +
                        "*****************************\r\n";
        //when
        OwingPrinter printOwing = new OwingPrinter();
        printOwing.printOwing("Jed", Collections.emptyList());

        //then
        assertTrue(outContent.toString().contains(header));
    }

    @Test
    public void printBannerContentWithOneOrder() {
        //given
        String content = "name: Jed\r\n"+
                "amount: 5.0\r\n";
        //when
        List<Order> orders = new ArrayList<>();
        Order orderVar = new Order(5);
        orders.add(orderVar);

        OwingPrinter printOwing = new OwingPrinter();
        printOwing.printOwing("Jed", orders);

        //then
        assertTrue(outContent.toString().contains(content));
    }

    @Test
    public void printBannerContentWithThreeOrder() {
        //given
        String content = "name: Jed\r\n"+
                "amount: 25.0\r\n";
        //when
        List<Order> orders = new ArrayList<>();
        Order orderOne = new Order(5);
        Order orderTwo = new Order(10);
        Order orderThree = new Order(10);
        orders.add(orderOne);
        orders.add(orderTwo);
        orders.add(orderThree);

        OwingPrinter printOwing = new OwingPrinter();
        printOwing.printOwing("Jed", orders);

        //then
        assertTrue(outContent.toString().contains(content));
    }
}