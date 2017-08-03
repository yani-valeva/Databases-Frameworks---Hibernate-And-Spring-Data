package softuni.bookshop.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.bookshop.entities.Book;
import softuni.bookshop.entities.Category;
import softuni.bookshop.entities.ReducedBook;
import softuni.bookshop.enums.AgeRestriction;
import softuni.bookshop.repositories.BookRepository;
import softuni.bookshop.services.BookService;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class BookServiceImpl implements BookService<Book, Long>{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book findById(Long id) {
        return bookRepository.findOne(id);
    }

    @Override
    public void remove(Book object) {
        bookRepository.delete(object);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book object) {
        bookRepository.save(object);
    }

    @Override
    public List<String> findAllBookTitlesWithReleaseDateAfter2000() {
        return bookRepository.findAllBookTitlesWithReleaseDateAfter2000();
    }

    @Override
    public List<Book> findAllBooksByGeorgePowell() {
        return bookRepository.findAllBooksByGeorgePowell();
    }

    @Override
    public List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction) {
        return this.bookRepository.findAllByAgeRestriction(ageRestriction);
    }

    @Override
    public List<Book> findByEditionAndCopies() {
        return this.bookRepository.findByEditionAndCopies();
    }

    @Override
    public List<Book> findAllBooksWithPriceLessThan5OrMoreThan40() {
        return this.bookRepository.findAllBooksWithPriceLessThan5OrMoreThan40();
    }

    @Override
    public List<Book> findBooksByReleaseDateNotIn(int year) {
        return this.bookRepository.findBooksByReleaseDateNotIn(year);
    }

    @Override
    public List<Book> findByCategoriesIn(List<Category> categories) {
        return this.bookRepository.findByCategoriesIn(categories);
    }

    @Override
    public List<Book> findByReleaseDateBefore(Date date) {
        return this.bookRepository.findByReleaseDateBefore(date);
    }

    @Override
    public List<Book> findAllByTitleContains(String pattern) {
        return this.bookRepository.findAllByTitleContains(pattern);
    }

    @Override
    public List<Book> findAllBooksByAuthorLastNameStartsWith(String pattern) {
        return this.bookRepository.findAllBooksByAuthorLastNameStartsWith(pattern);
    }

    @Override
    public Integer getCountByTitleLength(Integer length) {
        return this.bookRepository.getCountByTitleLength(length);
    }

    @Override
    public List<Object[]> findSumOfBookCopiesByAuthor() {
        return this.bookRepository.findSumOfBookCopiesByAuthor();
    }

    @Override
    public List<Object[]> findCountOfBooksByCategory() {
        return this.bookRepository.findCountOfBooksByCategory();
    }

    @Override
    public List<Book> findTop3ByCategoriesOrderByReleaseDateDescTitleAsc(Category category) {
        return this.bookRepository.findTop3ByCategoriesOrderByReleaseDateDescTitleAsc(category);
    }

    @Override
    public ReducedBook findReducedBooksByTitle(String title) {
        return this.bookRepository.findReducedBooksByTitle(title);
    }

    @Override
    @Modifying
    public Integer updateBookCopiesAfterGivenDate(Integer copies, Date date) {
        return this.bookRepository.updateBookCopiesAfterGivenDate(copies, date);
    }

    @Override
    @Modifying
    public Integer removeBooksWithCopiesLowerThan(Integer number) {
        return this.bookRepository.removeBooksWithCopiesLowerThan(number);
    }
}
