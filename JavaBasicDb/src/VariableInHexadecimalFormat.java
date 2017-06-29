import java.util.Scanner;

public class VariableInHexadecimalFormat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numberInHex = scanner.nextLine();
        int number = Integer.parseInt(numberInHex, 16);

        System.out.println(number);
    }
}
