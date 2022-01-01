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
    public void getTheSumOfXAndY() {
        assertEquals(4, stringCalculatorKata.add("1,3"));
        assertEquals(51, stringCalculatorKata.add("21,30"));
    }
}
