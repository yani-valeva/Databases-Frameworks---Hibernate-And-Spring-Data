package softuni.student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.student.entities.Homework;

import java.util.List;

@Repository
public interface HomeworkRepository extends JpaRepository<Homework, Long> {
}
