import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculatorKata {

    private String delimiter = "[,\n]";
    private String numbersString;

    public int add(String numbersString) throws Exception {
        this.numbersString = numbersString;

        if (isNumbersStringEmpty())
            return 0;

        if (numbersString.startsWith("//"))
            numbersString = getNumbersStringGivenCustomDelimiter();

        String[] numbers = numbersString.split(delimiter);
        throwExceptionGivenWrongFormatOf(numbers);

        return getSumOf(numbers);
    }

    private boolean isNumbersStringEmpty() {
        return numbersString.length() == 0;
    }

    private String getNumbersStringGivenCustomDelimiter() {
        String numbersString;
        delimiter = updateDelimiter();
        numbersString = subStringFromBeginningOfTheStringTillNewLine();
        return numbersString;
    }

    private void throwExceptionGivenWrongFormatOf(String[] numbers) throws Exception {
        throwExceptionGivenInputHasCommaOnly(numbers);
        throwExceptionGivenNegativesIn(numbers);
    }

    private void throwExceptionGivenInputHasCommaOnly(String[] numbers) {
        if (numbers.length == 0)
            throw new NumberFormatException("For input string: \",\"");
    }

    private void throwExceptionGivenNegativesIn(String[] numbers) throws Exception {
        String[] negatives = Arrays.stream(numbers)
                .filter(i -> Integer.parseInt(i) < 0)
                .toArray(String[]::new);
        if (negatives.length != 0)
            throw new Exception("negatives not allowed:" + Arrays.toString(negatives));
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
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);

        }
        return sum;
    }
}
