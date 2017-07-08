import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MinEvenNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> numbers = Arrays.asList(reader.readLine().split("\\s+"));
        Optional<Double> evenMinNumber = numbers.stream()
                .filter(s -> !s.isEmpty())
                .map(n -> Double.parseDouble(n))
                .filter(n -> n % 2 == 0)
                .min(Double::compare);

        if (evenMinNumber.isPresent()) {
            System.out.printf("%.2f", evenMinNumber.get());
        } else {
            System.out.println("No match");
        }
    }
}
