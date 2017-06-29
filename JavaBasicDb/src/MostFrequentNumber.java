import java.util.Arrays;
import java.util.Scanner;

public class MostFrequentNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int count = 1;
        int element = numbers[0];
        int maxCount = 0;

        for (int i = 0; i < numbers.length; i++) {
            int currentElement = numbers[i];
            for (int j = i; j < numbers.length - 1; j++) {
                if (currentElement == numbers[j + 1]) {
                    count++;
                }
            }

            if (maxCount < count) {
                maxCount = count;
                element = currentElement;
            }
            count = 1;
        }

        System.out.println(element);
    }
}
