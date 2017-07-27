package softuni.bookshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.bookshop.entities.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b.title FROM Book AS b " +
            "WHERE YEAR(b.releaseDate) > 2000")
    List<String> findAllBookTitlesWithReleaseDateAfter2000();

    @Query("SELECT b FROM Book AS b " +
            "WHERE b.author.firstName = 'George' AND b.author.lastName = 'Powell' " +
            "ORDER BY b.releaseDate DESC, b.title ASC")
    List<Book> findAllBooksByGeorgePowell();
}
