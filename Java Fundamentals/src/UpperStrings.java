import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class UpperStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> words = Arrays.asList(reader.readLine().split("\\s+"));
        words.stream()
                .map(w -> w.toUpperCase())
                .forEach(w -> System.out.printf(w + " "));
    }
}
