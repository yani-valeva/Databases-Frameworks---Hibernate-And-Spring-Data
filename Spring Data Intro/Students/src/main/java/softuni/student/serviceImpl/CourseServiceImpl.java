package softuni.student.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.student.entities.Course;
import softuni.student.repositories.CourseRepository;
import softuni.student.services.CourseService;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService<Course, Long> {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course findById(Long id) {
        return courseRepository.findOne(id);
    }

    @Override
    public void remove(Course object) {
        courseRepository.delete(object);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public void save(Course object) {
        courseRepository.save(object);
    }

    @Override
    public List<Object[]> findAllCoursesAndResources() {
        return courseRepository.findAllCoursesAndResources();
    }

    @Override
    public List<String> findAllCoursesWithMoreThan5Resources() {
        return courseRepository.findAllCoursesWithMoreThan5Resources();
    }

    @Override
    public List<Object[]> findAllCoursesActiveOnDate(Date date) {
        return courseRepository.findAllCoursesActiveOnDate(date);
    }
}
