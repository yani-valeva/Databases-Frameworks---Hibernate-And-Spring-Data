package averageGrades;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Double> grades;

    public Student() {
        this.grades = new ArrayList<>();
    }

    public Student(String name) {
        this();
        this.setName(name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getGrades() {
        return this.grades;
    }

    public void setGrades(List<Double> grades) {
        this.grades = grades;
    }

    public double getAverageGrade() {
        double sum = 0.0;

        for (Double grade : grades) {
            sum += grade;
        }

        return sum / grades.size();
    }
}
