package softuni.bookshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import softuni.bookshop.entities.Book;
import softuni.bookshop.entities.Category;
import softuni.bookshop.entities.ReducedBook;
import softuni.bookshop.enums.AgeRestriction;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // -------> FROM PREVIOUS HOMEWORK
    @Query("SELECT b.title FROM Book AS b " +
            "WHERE YEAR(b.releaseDate) > 2000")
    List<String> findAllBookTitlesWithReleaseDateAfter2000();

    // -------> FROM PREVIOUS HOMEWORK
    @Query("SELECT b FROM Book AS b " +
            "WHERE b.author.firstName = 'George' AND b.author.lastName = 'Powell' " +
            "ORDER BY b.releaseDate DESC, b.title ASC")
    List<Book> findAllBooksByGeorgePowell();

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    @Query("SELECT b FROM Book AS b WHERE b.editionType = 'GOLD' AND b.copies < 5000")
    List<Book> findByEditionAndCopies();

    @Query("SELECT b FROM Book AS b WHERE b.price < 5 OR b.price > 40")
    List<Book> findAllBooksWithPriceLessThan5OrMoreThan40();

    @Query("SELECT b FROM Book AS b WHERE YEAR(b.releaseDate) != :year")
    List<Book> findBooksByReleaseDateNotIn(@Param("year") int year);

    List<Book> findByCategoriesIn(List<Category> categories);

    List<Book> findByReleaseDateBefore(Date date);

    List<Book> findAllByTitleContains(String pattern);

    @Query("SELECT b FROM Book AS b WHERE b.author.lastName LIKE CONCAT(:pattern, '%')")
    List<Book> findAllBooksByAuthorLastNameStartsWith(@Param("pattern") String pattern);

    @Query("SELECT COUNT(b) FROM Book AS b WHERE LENGTH(b.title) > :length")
    Integer getCountByTitleLength(@Param("length") Integer length);

    @Query("SELECT a.firstName, a.lastName, SUM(b.copies) AS tbc FROM Book AS b " +
            "INNER JOIN b.author AS a " +
            "GROUP BY a.firstName, a.lastName " +
            "ORDER BY tbc DESC")
    List<Object[]> findSumOfBookCopiesByAuthor();

    @Query("SELECT c, COUNT(b) AS bookCount " +
            "FROM Book AS b " +
            "INNER JOIN b.categories AS c " +
            "GROUP BY c " +
            "HAVING COUNT(b) > 35 " +
            "ORDER BY bookCount DESC")
    List<Object[]> findCountOfBooksByCategory();

    List<Book> findTop3ByCategoriesOrderByReleaseDateDescTitleAsc(Category category);

    @Query("SELECT b FROM Book AS b WHERE b.title = :title")
    ReducedBook findReducedBooksByTitle(@Param("title") String title);

    @Modifying
    @Query("UPDATE Book AS b " +
            "SET b.copies = b.copies + :copies " +
            "WHERE b.releaseDate > :date")
    Integer updateBookCopiesAfterGivenDate(@Param("copies") Integer copies, @Param("date") Date date);

    @Modifying
    @Query("DELETE FROM Book AS b WHERE b.copies < :number")
    Integer removeBooksWithCopiesLowerThan(@Param("number") Integer number);
}
