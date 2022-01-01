public class StringCalculatorKata {

    public int add(String numbersStringWithCommas) {
        if (isEmpty(numbersStringWithCommas))
            return 0;

        String[] numbers = numbersStringWithCommas.split(",");
        return getSumOf(numbers);
    }

    private boolean isEmpty(String numbersStringWithCommas) {
        return numbersStringWithCommas.equals("");
    }

    private int getSumOf(String[] numbers) {
        int sum = 0;
        for (String number : numbers)
            sum += Integer.parseInt(number);
        return sum;
    }
}
