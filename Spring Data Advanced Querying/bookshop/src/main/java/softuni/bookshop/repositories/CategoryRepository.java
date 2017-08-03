package softuni.bookshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.bookshop.entities.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByNameIn(String[] names);

    @Query("SELECT c.name, SUM(b.copies * b.price) AS profit " +
            "FROM Category AS c " +
            "INNER JOIN c.books AS b " +
            "GROUP BY c.name " +
            "ORDER BY profit DESC, c.name ASC")
    List<Object[]> findTotalProfitOfBooksByCategory();
}
