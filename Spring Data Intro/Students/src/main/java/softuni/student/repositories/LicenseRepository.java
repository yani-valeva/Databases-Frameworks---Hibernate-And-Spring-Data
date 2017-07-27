package softuni.student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.student.entities.License;

@Repository
public interface LicenseRepository extends JpaRepository<License, Long> {
}
