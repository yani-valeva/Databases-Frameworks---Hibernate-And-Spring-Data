import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class FilterStudentsByPhone {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> students = new LinkedHashMap<>();
        String[] studentsInfo = reader.readLine().split("\\s+");
        String firstSfPhones = "02";
        String secondSfPhones = "+3592";

        while (!"END".equals(studentsInfo[0])) {
            String name = studentsInfo[0] + " " + studentsInfo[1];
            String phoneNumber = studentsInfo[2];
            students.put(name, phoneNumber);
            studentsInfo = reader.readLine().split("\\s+");
        }

        students.entrySet().stream()
                .filter(e -> e.getValue().startsWith(firstSfPhones) || e.getValue().startsWith(secondSfPhones))
                .forEach(n -> System.out.println(n.getKey()));
    }
}
