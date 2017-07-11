import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

public class StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String studentsInfo = reader.readLine();
        List<String> students = new ArrayList<>();

        while (!"END".equals(studentsInfo)) {
            students.add(studentsInfo);
            studentsInfo = reader.readLine();
        }

        students.stream()
                .filter(n -> n.split("\\s")[0].compareTo(n.split("\\s")[1]) < 0)
                .forEach(s -> System.out.println(String.format(s)));
    }
}