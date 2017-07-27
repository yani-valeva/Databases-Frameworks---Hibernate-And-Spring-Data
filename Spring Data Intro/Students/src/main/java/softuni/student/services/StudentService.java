package softuni.student.services;

import java.util.List;

public interface StudentService<Student, Long> extends InterfaceService<Student, Long> {
    List<Object[]> findAllStudentsAndHomeworkSubmissions();
    List<Object[]> findStudentInfo();
}
