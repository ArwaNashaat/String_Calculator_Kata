public class StringCalculatorKata {


    public int add(String numbersStringWithCommas) {
        final String delimiter = "[,\n]";

        if (isEmpty(numbersStringWithCommas))
            return 0;

        String[] numbers = numbersStringWithCommas.split(delimiter);
        return getSumOf(numbers);
    }

    private boolean isEmpty(String numbersStringWithCommas) {
        return numbersStringWithCommas.equals("");
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
