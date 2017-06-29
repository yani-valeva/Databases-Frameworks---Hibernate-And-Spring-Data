import java.util.Scanner;

public class IndexOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        char[] alphabet = new char[26];
        int k = 0;
        for(int i = 0; i < 26; i++){
            alphabet[i] = (char)(97 + (k++));
        }

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            for (int j = 0; j < alphabet.length; j++) {
                if (currentChar == alphabet[j]) {
                    System.out.println(String.format("%c -> %d", currentChar, j));
                    break;
                }
            }
        }
    }
}
