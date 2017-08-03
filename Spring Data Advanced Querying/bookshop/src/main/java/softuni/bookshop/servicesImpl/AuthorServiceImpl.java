package softuni.bookshop.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.bookshop.entities.Author;
import softuni.bookshop.repositories.AuthorRepository;
import softuni.bookshop.services.AuthorService;

import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService<Author, Long>{

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author findById(Long id) {
        return authorRepository.findOne(id);
    }

    @Override
    public void remove(Author object) {
        authorRepository.delete(object);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public void save(Author object) {
        authorRepository.save(object);
    }

    @Override
    public List<Author> findAllAuthorsWithBookReleaseDateBefore1990() {
        return authorRepository.findAllAuthorsWithBookReleaseDateBefore1990();
    }

    @Override
    public List<Object[]> findAllAuthorsByBooksNumber() {
        return authorRepository.findAllAuthorsByBooksNumber();
    }

    @Override
    public List<Author> findAllByFirstNameEndsWith(String pattern) {
        return this.authorRepository.findAllByFirstNameEndsWith(pattern);
    }
}
