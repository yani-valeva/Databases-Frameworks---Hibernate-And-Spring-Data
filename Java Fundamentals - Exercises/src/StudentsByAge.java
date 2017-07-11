import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StudentsByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] studentsInfo = reader.readLine().split("\\s+");
        Map<String, Integer> students = new LinkedHashMap<>();

        while (!"END".equals(studentsInfo[0])) {
            String name = studentsInfo[0] + " " + studentsInfo[1];
            int age = Integer.parseInt(studentsInfo[2]);
            students.put(name, age);
            studentsInfo = reader.readLine().split("\\s+");
        }

        students.entrySet().stream()
                .filter(a -> a.getValue() >= 18 && a.getValue() <= 24)
                .forEach(s -> System.out.println(String.format("%s %d", s.getKey(), s.getValue())));
    }
}
