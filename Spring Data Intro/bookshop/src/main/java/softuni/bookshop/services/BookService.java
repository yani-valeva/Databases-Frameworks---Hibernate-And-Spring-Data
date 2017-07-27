package softuni.bookshop.services;

import java.util.List;

public interface BookService<Book, Long> extends InterfaceService<Book, Long> {
    List<String> findAllBookTitlesWithReleaseDateAfter2000();
    List<Book> findAllBooksByGeorgePowell();
}
