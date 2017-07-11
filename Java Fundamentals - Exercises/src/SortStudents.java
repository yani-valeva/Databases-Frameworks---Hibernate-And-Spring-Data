import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SortStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> students = new ArrayList<>();
        String studentsInfo = reader.readLine();

        while (!"END".equals(studentsInfo)) {
            students.add(studentsInfo);
            studentsInfo = reader.readLine();
        }

        students.stream()
                .sorted((a, b) -> {
                    int result = a.split("\\s")[1].compareTo(b.split("\\s")[1]);
                    if (result == 0) {
                        result = b.split("\\s")[0].compareTo(a.split("\\s")[0]);
                    }

                    return result;
                })
                .forEach(n -> System.out.println(n));
    }
}
