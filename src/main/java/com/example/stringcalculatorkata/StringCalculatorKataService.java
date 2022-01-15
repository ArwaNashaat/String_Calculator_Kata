package com.example.stringcalculatorkata;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class StringCalculatorKataService {

    private String delimiter;
    private String string;

    public int add(String string) throws Exception {
        setDefaultDelimiterAndStringWith(string);

        if (string.isEmpty())
            return 0;

        updateClassFieldsIfCustomDelimiter();

        String[] numbers = this.string.split(delimiter);
        throwExceptionGivenWrongFormatOf(numbers);

        return getSumOfNumbersSmallerThan1001(numbers);
    }

    private void updateClassFieldsIfCustomDelimiter() throws Exception {
        if (string.startsWith("//")) {
            delimiter = updateDelimiter();
            string = removeTheDefinitionOfTheCustomDelimiter();
        }
    }

    private void setDefaultDelimiterAndStringWith(String string) {
        this.string = string;
        delimiter = "[,\n]";
    }

    private String removeTheDefinitionOfTheCustomDelimiter() {
        Matcher matcher = getMatcher();

        if (matcher.matches())
            return matcher.group(2);

        return "";
    }

    private void throwExceptionGivenWrongFormatOf(String[] numbers) throws Exception {
        throwExceptionGivenStringHasCommaOnly(numbers);
        throwExceptionGivenNegativesIn(numbers);
    }

    private void throwExceptionGivenStringHasCommaOnly(String[] numbers) {
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
        return Pattern.compile(customDelimiterPattern).matcher(string);
    }

    private String updateDelimiter() throws Exception {
        Matcher matcher = getMatcher();
        if (matcher.matches()) {
            return matcher.group(1);
        }
        throw new Exception("Invalid Delimiter");
    }

    private int getSumOfNumbersSmallerThan1001(String[] numbers) {
        String[] numberSmallerThan1001 = getNumbersSmallerThan1001(numbers);
        return getSumOf(numberSmallerThan1001);
    }

    private String[] getNumbersSmallerThan1001(String[] numbers) {
        return Arrays.stream(numbers)
                .filter(i -> Integer.parseInt(i) < 1000 && Integer.parseInt(i) >= 0)
                .toArray(String[]::new);
    }

    private int getSumOf(String[] numbers) {
        int sum = 0;

        for (String number : numbers)
            sum += Integer.parseInt(number);

        return sum;
    }
}
