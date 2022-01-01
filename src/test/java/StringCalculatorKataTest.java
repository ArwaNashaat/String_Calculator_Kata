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
    public void addEmptyStringReturnZero() {
        assertEquals(0, stringCalculatorKata.add(""));
    }

    @Test
    public void addXReturnsX() {
        assertEquals(1, stringCalculatorKata.add("1"));
        assertEquals(20, stringCalculatorKata.add("20"));
        assertEquals(300, stringCalculatorKata.add("300"));
    }

    @Test
    public void getTheSumOfXAndYSeparatedByCommaOnly() {
        assertEquals(4, stringCalculatorKata.add("1,3"));
        assertEquals(51, stringCalculatorKata.add("21,30"));
    }

    @Test
    public void getTheSumOfMoreThanTwoNumbersSeparatedByCommaOnly() {
        assertEquals(20, stringCalculatorKata.add("1,3,6,10"));
        assertEquals(51, stringCalculatorKata.add("21,30,0"));
        assertEquals(67, stringCalculatorKata.add("21,30,10,5,1"));
    }

    @Test
    public void getTheSumOfTwoNumbersNewLineSeparatedOnly() {
        assertEquals(5, stringCalculatorKata.add("2\n3"));
    }

    @Test
    public void getTheSumOfMoreThanTwoNumbersSeparatedByCommaAndNewLine() {
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
    public void getTheSumOfTwoNumbersWhenTheDefaultDelimiterIsSemicolon() {
        assertEquals(5, stringCalculatorKata.add("//;\n2;3"));
    }
}
