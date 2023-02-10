import java.util.ArrayList;
import java.util.List;

public class TDD {
    public static void main(String[] args) {
        //int[] numbers = {6, 7, 153, 11, 13, 407};
        System.out.println(isArmstrong(153));

    }

    public static boolean isArmstrongConsecutive(int[] numbers) {
        int counter = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (isArmstrong(numbers[i])) {
                counter++;
            } else {
                counter = 0;
            }
        }
        return counter == 3;
    }

    public static boolean isArmstrong(int number) {
        int sum = 0;
        int numberToCompare = number;
        List<Integer> numberList = new ArrayList<>();

        while (number > 0) {
            final int remainder = number % 10;
            numberList.add(remainder);
            number = (number - remainder) / 10;
        }

        for (Integer i : numberList) {
            sum += Math.pow(i, 3);
        }

        return sum == numberToCompare;
    }
}
