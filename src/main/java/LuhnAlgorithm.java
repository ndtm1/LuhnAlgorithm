public class LuhnAlgorithm {

    public String makeCheckSum(String seqNumbers) {

        int[] numbersToSave = fillArray(seqNumbers, false);
        int[] numbers = fillArray(seqNumbers, false);

        if (((numbers.length - 1) % 2) == 0) {

            for (int i = 1; i < numbers.length - 1; i += 2)
                numbers[i] = multiplyTwoAndSubtractIfOverNine(numbers[i]);

            int finalDigit = getFinalDigit(numbers, false);
            numbersToSave[seqNumbers.length()] = finalDigit;

        } else {

            for (int i = 0; i < numbers.length - 1; i += 2) {
                numbers[i] = multiplyTwoAndSubtractIfOverNine(numbers[i]);

                int finalDigit = getFinalDigit(numbers, false);
                numbersToSave[seqNumbers.length()] = finalDigit;
            }
        }

        return seqToString(numbersToSave);
    }

    public boolean verifyCheckSum(String numberWithCheckDigit) {
        int[] numbers = fillArray(numberWithCheckDigit, true);

        if (((numbers.length - 1) % 2) == 0) {

            for (int i = 1; i < numbers.length - 1; i += 2)
                numbers[i] = multiplyTwoAndSubtractIfOverNine(numbers[i]);

            int finalDigit = getFinalDigit(numbers, true);

            return (finalDigit % 10) == 0;
        } else {

            for (int i = 0; i < numbers.length - 1; i += 2)
                numbers[i] = multiplyTwoAndSubtractIfOverNine(numbers[i]);


            int finalDigit = getFinalDigit(numbers, true);

            return (finalDigit % 10) == 0;
        }
    }

    private int[] fillArray(String seqNumbers, boolean verify) {
        int[] numbers;

        if(!verify) {
            numbers = new int[seqNumbers.length() + 1];
        } else
            numbers = new int[seqNumbers.length()];

        for(int i = 0; i < seqNumbers.length(); i++) {
            numbers[i] = Integer.parseInt(String.valueOf(seqNumbers.charAt(i)));
        }

        return numbers;
    }

    private int multiplyTwoAndSubtractIfOverNine(int number) {
        number = number * 2;

        return (number > 9) ? number - 9 : number;
    }

    private int getFinalDigit(int[] numbers, boolean verify) {
        int finalNumber = 0;

        for(int i = 0; i < numbers.length - 1; i++)
            finalNumber += numbers[i];

        int temp = finalNumber;
        if(!verify) {
            finalNumber = (int) (Math.ceil(temp / 10f) * 10) - temp;
        } else {
            finalNumber = temp + numbers[numbers.length - 1];
        }

        return finalNumber;
    }

    private String seqToString(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        for(int i : numbers) {

            sb.append(i);
        }

        return sb.toString();
    }
}