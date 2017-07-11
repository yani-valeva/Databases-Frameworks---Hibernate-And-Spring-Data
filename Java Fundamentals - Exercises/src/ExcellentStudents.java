import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcellentStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Integer>> students = new LinkedHashMap<>();
        String[] studentsInfo = reader.readLine().split("\\s+");

        while (!"END".equals(studentsInfo[0])) {
            String name = studentsInfo[0] + " " + studentsInfo[1];
            List<Integer> grades = new ArrayList<>();

            for (int i = 2; i < studentsInfo.length; i++) {
                grades.add(Integer.parseInt(studentsInfo[i]));
            }

            students.put(name, grades);
            studentsInfo = reader.readLine().split("\\s+");
        }

        students.entrySet().stream()
                .filter(g -> g.getValue().contains(6))
                .forEach(s -> System.out.println(s.getKey()));
    }
}
