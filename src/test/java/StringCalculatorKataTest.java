import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringCalculatorKataTest {

    @Test
    public void addEmptyStringReturnZero() {
        StringCalculatorKata stringCalculatorKata = new StringCalculatorKata();
        assertEquals(0, stringCalculatorKata.add(""));
    }
}
