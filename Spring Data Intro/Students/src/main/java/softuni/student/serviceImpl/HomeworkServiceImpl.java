package softuni.student.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.student.entities.Homework;
import softuni.student.repositories.HomeworkRepository;
import softuni.student.services.HomeworkService;

import java.util.List;

@Service
@Transactional
public class HomeworkServiceImpl implements HomeworkService<Homework, Long> {

    @Autowired
    private HomeworkRepository homeworkRepository;

    @Override
    public Homework findById(Long id) {
        return homeworkRepository.findOne(id);
    }

    @Override
    public void remove(Homework object) {
        homeworkRepository.delete(object);
    }

    @Override
    public List<Homework> findAll() {
        return homeworkRepository.findAll();
    }

    @Override
    public void save(Homework object) {
        homeworkRepository.save(object);
    }
}
