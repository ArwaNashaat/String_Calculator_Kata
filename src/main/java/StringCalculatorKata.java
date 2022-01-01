import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculatorKata {

    String delimiter = "[,\n]";
    String numbersString;

    public int add(String numbersString) {
        setNumbersString(numbersString);

        if (isNumbersStringEmpty())
            return 0;

        if (numbersString.startsWith("//")) {
            delimiter = updateDelimiter();
            numbersString = subStringFromBeginningOfTheStringTillNewLine();
        }

        String[] numbers = numbersString.split(delimiter);
        return getSumOf(numbers);
    }

    private void setNumbersString(String numbersString) {
        this.numbersString = numbersString;
    }

    private boolean isNumbersStringEmpty() {
        return numbersString.equals("");
    }

    private Matcher getMatcher() {
        String customDelimiterPattern = "//(.)\n(.*)";

        return Pattern.compile(customDelimiterPattern).matcher(numbersString);
    }

    private String updateDelimiter() {
        Matcher matcher = getMatcher();
        if (matcher.matches())
            return matcher.group(1);
        return "";
    }

    private String subStringFromBeginningOfTheStringTillNewLine() {
        Matcher matcher = getMatcher();

        if (matcher.matches())
            return matcher.group(2);

        return "";
    }

    private int getSumOf(String[] numbers) {
        if (numbers.length == 0)
            throw new NumberFormatException("For input string: \",\"");
        int sum = 0;
        for (String number : numbers)
            sum += Integer.parseInt(number);
        return sum;
    }
}
