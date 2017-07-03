package averageGrades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int studentsCount = Integer.parseInt(reader.readLine());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < studentsCount; i++) {
            List<Double> studentGrades = new ArrayList<>();
            String[] studentsInfo = reader.readLine().split("\\s+");
            String name = studentsInfo[0];

            for (int j = 1; j < studentsInfo.length; j++) {
                studentGrades.add(Double.parseDouble(studentsInfo[j]));
            }

            Student student = new Student(name);
            student.setGrades(studentGrades);
            students.add(student);
        }

        students.stream()
                .filter(g -> g.getAverageGrade() >= 5)
                .sorted((a, b) -> {
                    int result = a.getName().compareTo(b.getName());
                    if (result == 0) {
                        result = Double.compare(b.getAverageGrade(), a.getAverageGrade());
                    }

                    return result;
                }).forEach(s -> System.out.printf("%s -> %.2f%n", s.getName(), s.getAverageGrade()));
    }
}
