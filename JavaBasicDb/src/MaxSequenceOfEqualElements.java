import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = 1;
        int start = 0;
        int maxCount = 0;
        int bestStart = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                    bestStart = start;
                }
                count = 1;
                start = i + 1;
            }

            if (i == numbers.length - 2) {
                if (count > maxCount) {
                    maxCount = count;
                    bestStart = start;
                }
            }
        }

        for (int i = 0; i < maxCount; i++) {
            System.out.printf("%d ", numbers[bestStart + i]);
        }
    }
}
