package softuni.student.entities;

import softuni.student.enums.MyContentType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "homeworks")
public class Homework {
    private Long id;
    private String content;
    private MyContentType contentType;
    private Date submissionDate;
    private Course course;
    private Student student;

    public Homework() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "content", columnDefinition = "TEXT", nullable = false)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "content_type", nullable = false)
    public MyContentType getContentType() {
        return contentType;
    }

    public void setContentType(MyContentType contentType) {
        this.contentType = contentType;
    }

    @Column(name = "submission_date", nullable = false)
    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
