package softuni.bookshop.services;

import java.util.List;

public interface AuthorService<Author, Long> extends InterfaceService<Author, Long> {
    List<Author> findAllAuthorsWithBookReleaseDateBefore1990();
    List<Object[]> findAllAuthorsByBooksNumber();
    List<Author> findAllByFirstNameEndsWith(String pattern);
}
