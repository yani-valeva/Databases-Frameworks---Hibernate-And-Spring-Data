package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
@PrimaryKeyJoinColumn(name = "id")
//@DiscriminatorValue(value = "Students")
public class Student extends People{
    private Double averageGrade;
    private Long attendance;
    private Set<Course> courses;

    public Student() {
    }

    @Column(name = "average_grade")
    public Double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(Double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Basic
    public Long getAttendance() {
        return attendance;
    }

    public void setAttendance(Long attendance) {
        this.attendance = attendance;
    }

    @ManyToMany(mappedBy = "enrolledStudents")
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
