import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class FilterStudentsByEmailDomain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> students = new LinkedHashMap<>();
        String[] studentsInfo = reader.readLine().split("\\s+");
        String domain = "@gmail.com";

        while (!"END".equals(studentsInfo[0])) {
            String name = studentsInfo[0] + " " + studentsInfo[1];
            String email = studentsInfo[2];
            students.put(name, email);
            studentsInfo = reader.readLine().split("\\s+");
        }

        students.entrySet().stream()
                .filter(e -> e.getValue().endsWith(domain))
                .forEach(n -> System.out.println(n.getKey()));
    }
}
