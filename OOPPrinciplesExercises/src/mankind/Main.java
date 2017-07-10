package mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] studentsInfo = reader.readLine().split("\\s+");
            String[] workerInfo = reader.readLine().split("\\s+");

            String studentFirstName = studentsInfo[0].trim();
            String studentLastName = studentsInfo[1].trim();
            String facultyNamber = studentsInfo[2].trim();
            Human student = new Student(studentFirstName, studentLastName, facultyNamber);

            String workerFirstName = workerInfo[0].trim();
            String workerLastName = workerInfo[1].trim();
            double workerSalary = Double.parseDouble(workerInfo[2].trim());
            double workHoursPerDay = Double.parseDouble(workerInfo[3].trim());
            Human worker = new Worker(workerFirstName, workerLastName, workerSalary, workHoursPerDay);

            System.out.println(student.toString());
            System.out.println(worker.toString());
        }  catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return;
        }
    }
}
