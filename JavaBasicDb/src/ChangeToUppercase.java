import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChangeToUppercase {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();
        String start = "<upcase>";
        String end = "</upcase>";

        int startIndex = text.indexOf(start);
        int endIndex = text.indexOf(end);

        while (startIndex >= 0 && endIndex >= 0) {
            String replacement = text.substring(startIndex + start.length(), endIndex).toUpperCase();
            String oldPartOfText = text.substring(startIndex, endIndex + end.length());
            text = text.replace(oldPartOfText, replacement);
            startIndex = text.indexOf(start, startIndex + 1);
            endIndex = text.indexOf(end, endIndex + 1);
        }

        System.out.println(text);
    }
}
