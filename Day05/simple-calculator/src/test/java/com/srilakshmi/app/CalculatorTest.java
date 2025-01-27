package com.srilakshmi.app;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        double result=calculator.add(6,4);
        assert result==10;
    }
    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        double result = calculator.subtract(12,6);
        assert result==6;
    }
    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        double result= calculator.multiply(3,4);
        assert result==12;
    }
    @Test
    public void testDivision(){
        Calculator calculator = new Calculator();
        double result = calculator.divide(10,2);
        assert result==5;
    }
}
