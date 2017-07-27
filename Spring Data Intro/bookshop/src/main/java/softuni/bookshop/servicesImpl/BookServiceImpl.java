package softuni.bookshop.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.bookshop.entities.Book;
import softuni.bookshop.repositories.BookRepository;
import softuni.bookshop.services.BookService;

import java.util.List;

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
}
