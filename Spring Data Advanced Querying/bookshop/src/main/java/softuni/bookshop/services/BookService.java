package softuni.bookshop.services;

import org.springframework.data.repository.query.Param;
import softuni.bookshop.entities.Category;
import softuni.bookshop.entities.ReducedBook;
import softuni.bookshop.enums.AgeRestriction;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface BookService<Book, Long> extends InterfaceService<Book, Long> {
    List<String> findAllBookTitlesWithReleaseDateAfter2000();
    List<Book> findAllBooksByGeorgePowell();
    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);
    List<Book> findByEditionAndCopies();
    List<Book> findAllBooksWithPriceLessThan5OrMoreThan40();
    List<Book> findBooksByReleaseDateNotIn(@Param("year") int year);
    List<Book> findByCategoriesIn(List<Category> categories);
    List<Book> findByReleaseDateBefore(Date date);
    List<Book> findAllByTitleContains(String pattern);
    List<Book> findAllBooksByAuthorLastNameStartsWith(@Param("pattern") String pattern);
    Integer getCountByTitleLength(@Param("length") Integer length);
    List<Object[]> findSumOfBookCopiesByAuthor();
    List<Object[]> findCountOfBooksByCategory();
    List<Book> findTop3ByCategoriesOrderByReleaseDateDescTitleAsc(Category category);
    ReducedBook findReducedBooksByTitle(@Param("title") String title);
    Integer updateBookCopiesAfterGivenDate(@Param("copies") Integer copies, @Param("date") Date date);
    Integer removeBooksWithCopiesLowerThan(@Param("number") Integer number);
}
