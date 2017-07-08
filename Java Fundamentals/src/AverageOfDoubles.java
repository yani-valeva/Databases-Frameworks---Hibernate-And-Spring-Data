import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class AverageOfDoubles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> numbers = Arrays.asList(reader.readLine().split("\\s+"));
        OptionalDouble average = numbers.stream()
                .filter(n -> !n.isEmpty())
                .mapToDouble(n -> Double.parseDouble(n))
                .average();

        if (average.isPresent()) {
            System.out.printf("%.2f%n", average.getAsDouble());
        } else {
            System.out.println("No match");
        }
    }
}
