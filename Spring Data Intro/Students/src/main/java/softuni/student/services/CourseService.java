package softuni.student.services;

import java.util.Date;
import java.util.List;

public interface CourseService<Course, Long> extends InterfaceService<Course, Long> {
    List<Object[]> findAllCoursesAndResources();

    List<String> findAllCoursesWithMoreThan5Resources();

    List<Object[]> findAllCoursesActiveOnDate(Date date);
}
