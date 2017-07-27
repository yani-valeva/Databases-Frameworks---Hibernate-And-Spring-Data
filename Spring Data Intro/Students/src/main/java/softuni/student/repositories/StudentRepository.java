package softuni.student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.student.entities.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s.name, h.content, h.contentType FROM Student AS s INNER JOIN s.homeworks AS h")
    List<Object[]> findAllStudentsAndHomeworkSubmissions();

    @Query("SELECT s.name, COUNT(c), SUM(c.price), AVG(c.price) FROM Student AS s INNER JOIN s.courses AS c " +
            "GROUP BY s.name " +
            "ORDER BY SUM(c.price) DESC, COUNT(c) DESC , s.name ASC")
    List<Object[]> findStudentInfo();
}
