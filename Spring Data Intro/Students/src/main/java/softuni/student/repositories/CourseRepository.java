package softuni.student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.student.entities.Course;

import java.util.Date;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT c.name, c.description, r FROM Course AS c INNER JOIN c.resources AS r ORDER BY c.startDate ASC, c.endDate DESC ")
    List<Object[]> findAllCoursesAndResources();


    @Query("SELECT concat(c.name, ' ', COUNT(r)) FROM Course AS c INNER JOIN c.resources AS r GROUP BY c.name " +
            "HAVING COUNT(r) > 1 ORDER BY COUNT(r) DESC, c.startDate DESC")
    List<String> findAllCoursesWithMoreThan5Resources();

    @Query("SELECT c.name, c.startDate, c.endDate, datediff(c.endDate, c.startDate), COUNT(s) FROM Course AS c INNER JOIN c.students AS s " +
            "GROUP BY c.name, c.startDate, c.endDate " +
            "HAVING c.startDate < :date and c.endDate > :date " +
            "ORDER BY COUNT(s) DESC, datediff(c.endDate, c.startDate) desc")
    List<Object[]> findAllCoursesActiveOnDate(@Param("date")Date date);
}
