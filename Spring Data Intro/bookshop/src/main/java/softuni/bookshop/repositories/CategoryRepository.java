package softuni.bookshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bookshop.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
