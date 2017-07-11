import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StudentsByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] studentsInfo = reader.readLine().split("\\s+");
        Map<String, Integer> students = new HashMap<>();

        while (!"END".equals(studentsInfo[0])) {
            String name = studentsInfo[0] + " " + studentsInfo[1];
            int group = Integer.parseInt(studentsInfo[2]);
            students.put(name, group);
            studentsInfo = reader.readLine().split("\\s+");
        }

        students.entrySet().stream()
                .filter(g -> g.getValue() == 2)
                .sorted((a, b) -> a.getKey().split("\\s")[0].compareTo(b.getKey().split("\\s")[0]))
                .forEach(s -> System.out.println(s.getKey()));
    }
}
