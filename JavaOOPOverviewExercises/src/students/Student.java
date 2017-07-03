package students;

public class Student {
    public static Integer studentsCount = 0;
    private String name;

    public Student(String name) {
        this.name = name;
        studentsCount++;
    }
}
