import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WeakStudents {
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
                .filter(g -> {
                    List<Integer> weakGrades = new ArrayList<>();
                    weakGrades = g.getValue().stream().filter(cg -> cg <= 3).collect(Collectors.toList());
                    return weakGrades.size() >= 2;
                })
                .forEach(s -> System.out.println(s.getKey()));
    }
}
