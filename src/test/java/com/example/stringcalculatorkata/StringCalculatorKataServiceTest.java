package com.example.stringcalculatorkata;

import static org.junit.jupiter.api.Assertions.*;

import com.example.stringcalculatorkata.StringCalculatorKataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringCalculatorKataServiceTest {

    private StringCalculatorKataService stringCalculatorKataService;

    @BeforeEach
    void setUp() {
        stringCalculatorKataService = new StringCalculatorKataService();
    }

    @Test
    public void emptyStringReturnZero() throws Exception {
        assertEquals(0, stringCalculatorKataService.add(""));
    }

    @Test
    public void oneNumberReturnsTheSameNumber() throws Exception {
        assertEquals(1, stringCalculatorKataService.add("1"));
        assertEquals(20, stringCalculatorKataService.add("20"));
        assertEquals(300, stringCalculatorKataService.add("300"));
    }

    @Test
    public void sumOfTwoNumbersCommaDelimiter() throws Exception {
        assertEquals(4, stringCalculatorKataService.add("1,3"));
        assertEquals(51, stringCalculatorKataService.add("21,30"));
    }

    @Test
    public void sumOfMoreThanTwoNumbers_CommaDelimiter() throws Exception {
        assertEquals(20, stringCalculatorKataService.add("1,3,6,10"));
        assertEquals(51, stringCalculatorKataService.add("21,30,0"));
        assertEquals(67, stringCalculatorKataService.add("21,30,10,5,1"));
    }

    @Test
    public void sumOfTwoNumbers_NewLineDelimiter() throws Exception {
        assertEquals(5, stringCalculatorKataService.add("2\n3"));
    }

    @Test
    public void sumOfMoreThanTwoNumbersCommaAndNewLineDelimiter() throws Exception {
        assertEquals(11, stringCalculatorKataService.add("2\n3,6"));
        assertEquals(12, stringCalculatorKataService.add("2,3\n6\n1"));
    }

    @Test
    public void throwNumberFormatExceptionWhenTheStringContainsCommaOnly() {
        NumberFormatException numberFormatException = assertThrows(NumberFormatException.class, () -> stringCalculatorKataService.add(","));
        assertEquals("For input string: \",\"", numberFormatException.getMessage());

        numberFormatException = assertThrows(NumberFormatException.class, () -> stringCalculatorKataService.add(",,"));
        assertEquals("For input string: \",\"", numberFormatException.getMessage());
    }

    @Test
    public void sumOfTwoNumbers_SemicolonDelimiter() throws Exception {
        assertEquals(5, stringCalculatorKataService.add("//;\n2;3"));
    }

    @Test
    public void getTheSumOfXSemicolonY_AndAfter_GetTheSumOfXCommaY() throws Exception {
        assertEquals(5, stringCalculatorKataService.add("//;\n2;3"));
        assertEquals(5, stringCalculatorKataService.add("2,3"));
    }

    @Test
    public void throwExceptionGivenNegativeNumbers() {
        Exception exception = assertThrows(Exception.class, () -> stringCalculatorKataService.add("-5,9"));
        assertEquals("negatives not allowed:[-5]", exception.getMessage());

        exception = assertThrows(Exception.class, () -> stringCalculatorKataService.add("-5,-9"));
        assertEquals("negatives not allowed:[-5, -9]", exception.getMessage());
    }

    @Test
    public void doNotSumNumbersAbove1000() throws Exception {
        assertEquals(2, stringCalculatorKataService.add("2,1001,20000"));
    }

    @Test
    public void throwExceptionWhenCustomDelimiterDoesNotFollowTheFormat() {
        Exception exception = assertThrows(Exception.class, ()-> stringCalculatorKataService.add("//;;\n5;;3"));
        assertEquals("Invalid Delimiter", exception.getMessage());
    }
}
