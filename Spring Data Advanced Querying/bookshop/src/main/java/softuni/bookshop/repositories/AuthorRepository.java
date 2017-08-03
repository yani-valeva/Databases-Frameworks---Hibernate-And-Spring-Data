package softuni.bookshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.bookshop.entities.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    // -------> FROM PREVIOUS HOMEWORK
    @Query("SELECT a " +
            "FROM Author AS a " +
            "INNER JOIN a.books AS b " +
            "WHERE YEAR(b.releaseDate) < 1990")
    List<Author> findAllAuthorsWithBookReleaseDateBefore1990();

    // -------> FROM PREVIOUS HOMEWORK
    @Query("SELECT a.firstName, a.lastName, count(*) AS number " +
            "FROM Author AS a " +
            "INNER JOIN a.books AS b " +
            "GROUP BY a.firstName, a.lastName " +
            "ORDER BY number DESC")
    List<Object[]> findAllAuthorsByBooksNumber();

    List<Author> findAllByFirstNameEndsWith(String pattern);
}
