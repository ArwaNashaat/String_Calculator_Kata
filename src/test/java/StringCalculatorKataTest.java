import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringCalculatorKataTest {

    private StringCalculatorKata stringCalculatorKata;

    @BeforeEach
    void setUp() {
        stringCalculatorKata = new StringCalculatorKata();
    }

    @Test
    public void emptyStringReturnZero() throws Exception {
        assertEquals(0, stringCalculatorKata.add(""));
    }

    @Test
    public void oneNumberReturnsTheSameNumber() throws Exception {
        assertEquals(1, stringCalculatorKata.add("1"));
        assertEquals(20, stringCalculatorKata.add("20"));
        assertEquals(300, stringCalculatorKata.add("300"));
    }

    //Underscore breaks the java convention for the functions, but it's more readable this way...
    @Test
    public void sumOfTwoNumbers_CommaDelimiter() throws Exception {
        assertEquals(4, stringCalculatorKata.add("1,3"));
        assertEquals(51, stringCalculatorKata.add("21,30"));
    }

    @Test
    public void sumOfMoreThanTwoNumbers_CommaDelimiter() throws Exception {
        assertEquals(20, stringCalculatorKata.add("1,3,6,10"));
        assertEquals(51, stringCalculatorKata.add("21,30,0"));
        assertEquals(67, stringCalculatorKata.add("21,30,10,5,1"));
    }

    @Test
    public void sumOfTwoNumbers_NewLineDelimiter() throws Exception {
        assertEquals(5, stringCalculatorKata.add("2\n3"));
    }

    @Test
    public void sumOfMoreThanTwoNumbers_CommaAndNewLineDelimiter() throws Exception {
        assertEquals(11, stringCalculatorKata.add("2\n3,6"));
        assertEquals(12, stringCalculatorKata.add("2,3\n6\n1"));
    }

    @Test
    public void throwNumberFormatExceptionWhenTheStringContainsCommaOnly() {
        NumberFormatException numberFormatException = assertThrows(NumberFormatException.class, () -> stringCalculatorKata.add(","));
        assertEquals("For input string: \",\"", numberFormatException.getMessage());

        numberFormatException = assertThrows(NumberFormatException.class, () -> stringCalculatorKata.add(",,"));
        assertEquals("For input string: \",\"", numberFormatException.getMessage());
    }

    @Test
    public void sumOfTwoNumbers_SemicolonDelimiter() throws Exception {
        assertEquals(5, stringCalculatorKata.add("//;\n2;3"));
    }

    @Test
    public void getTheSumOfXSemicolonY_AndAfter_GetTheSumOfXCommaY() throws Exception {
        assertEquals(5, stringCalculatorKata.add("//;\n2;3"));
        assertEquals(5, stringCalculatorKata.add("2,3"));
    }

    @Test
    public void throwExceptionGivenNegativeNumbers() {
        Exception exception = assertThrows(Exception.class, () -> stringCalculatorKata.add("-5,9"));
        assertEquals("negatives not allowed:[-5]", exception.getMessage());

        exception = assertThrows(Exception.class, () -> stringCalculatorKata.add("-5,-9"));
        assertEquals("negatives not allowed:[-5, -9]", exception.getMessage());
    }
}
