import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudentsEnrolledin2014or2015 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Integer>> students = new LinkedHashMap<>();
        String[] studentsInfo = reader.readLine().split("\\s+");

        while (!"END".equals(studentsInfo[0])) {
            String facultyNumber = studentsInfo[0];
            List<Integer> grades = new ArrayList<>();

            for (int i = 1; i < studentsInfo.length; i++) {
                grades.add(Integer.parseInt(studentsInfo[i]));
            }

            students.put(facultyNumber, grades);
            studentsInfo = reader.readLine().split("\\s+");
        }

        students.entrySet().stream()
                .filter(s -> s.getKey().endsWith("14") || s.getKey().endsWith("15"))
                .forEach(s -> System.out.println(s.getValue().toString().replaceAll("\\[|]|,","")));
    }
}
