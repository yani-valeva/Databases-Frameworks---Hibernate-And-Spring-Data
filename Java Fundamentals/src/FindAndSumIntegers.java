import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindAndSumIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> elements = Arrays.asList(reader.readLine().split("\\s+"));

        Optional<Integer> sum = elements.stream()
                .filter(s -> !s.isEmpty())
                .filter(s -> isNumber(s))
                .map(s -> Integer.parseInt(s))
                .reduce((a, b) -> a + b);

        if (sum.isPresent()) {
            System.out.println(sum.get());
        } else {
            System.out.println("No match");
        }
    }

    private static boolean isNumber(String s) {

        try {
            int currentNumber = Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
