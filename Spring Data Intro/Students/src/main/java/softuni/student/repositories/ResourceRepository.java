package softuni.student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.student.entities.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
