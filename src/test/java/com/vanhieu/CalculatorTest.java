package com.vanhieu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @Test
    public void testSum() {
        assertEquals(5, calculator.sum(2, 3));
    }

    @Test
    public void testMultiply() {
        assertEquals(10, calculator.multiply(2, 5));
    }

    @Test
    public void testMultiply1() {
        assertEquals(14, calculator.multiply(3, 5));
    }
}