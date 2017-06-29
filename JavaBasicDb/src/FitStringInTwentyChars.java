import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FitStringInTwentyChars {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String text = buffer.readLine();

        if (text.length() <= 20) {
            System.out.println(addStars(text));
        } else {
            System.out.println(text.substring(0, 20));
        }
    }

    public static String addStars (String text) {
        int difference = 20 - text.length();
        StringBuilder sb = new StringBuilder(text);

        for (int i = 0; i < difference; i++) {
             sb.append("*");
        }

        return sb.toString();
    }
}
