import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FirstName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.asList(reader.readLine().split("\\s+"));
        char letter = reader.readLine().toLowerCase().charAt(0);

        Optional<String> firstName = names.stream()
                .filter(n -> n.charAt(0) == letter)
                .sorted()
                .findFirst();

        if (firstName.isPresent()) {
            System.out.println(firstName.get());
        } else {
            System.out.println("No match");
        }
    }
}
