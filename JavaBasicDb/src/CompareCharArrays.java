import java.util.Scanner;

public class CompareCharArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String first = scanner.nextLine().replace(" ", "").toString();
        String second = scanner.nextLine().replace(" ", "").toString();


        if (first.compareTo(second) <= 1) {
            System.out.println(first);
            System.out.println(second);
        } else {
            System.out.println(second);
            System.out.println(first);
        }
    }
}
