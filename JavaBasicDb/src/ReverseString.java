import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append(word).reverse());
    }
}
