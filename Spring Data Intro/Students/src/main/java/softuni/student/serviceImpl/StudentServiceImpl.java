package softuni.student.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.student.entities.Student;
import softuni.student.repositories.StudentRepository;
import softuni.student.services.StudentService;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService<Student, Long> {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student findById(Long id) {
        return studentRepository.findOne(id);
    }

    @Override
    public void remove(Student object) {
        studentRepository.delete(object);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student object) {
        studentRepository.save(object);
    }

    @Override
    public List<Object[]> findAllStudentsAndHomeworkSubmissions() {
        return studentRepository.findAllStudentsAndHomeworkSubmissions();
    }

    @Override
    public List<Object[]> findStudentInfo() {
        return studentRepository.findStudentInfo();
    }
}
