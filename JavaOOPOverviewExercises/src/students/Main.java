package students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();

        while (!name.equals("End")) {
            Student student = new Student(name);
            name = reader.readLine();
        }

        System.out.println(Student.studentsCount);
    }
}
