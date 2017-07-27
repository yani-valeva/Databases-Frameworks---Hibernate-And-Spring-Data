package softuni.bookshop.terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.bookshop.entities.Author;
import softuni.bookshop.entities.Book;
import softuni.bookshop.entities.Category;
import softuni.bookshop.enums.AgeRestriction;
import softuni.bookshop.enums.EditionType;
import softuni.bookshop.repositories.AuthorRepository;
import softuni.bookshop.repositories.BookRepository;
import softuni.bookshop.services.AuthorService;
import softuni.bookshop.services.BookService;
import softuni.bookshop.services.CategoryService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private BookService<Book, Long> bookService;

    @Autowired
    private AuthorService<Author, Long> authorService;

    @Autowired
    private CategoryService<Category, Long> categoryService;

    @Override
    public void run(String... strings) throws Exception {
        // seed data into Db
//        seed();

        //query 3.1
//        List<String> books = bookService.findAllBookTitlesWithReleaseDateAfter2000();
//        books.forEach(t -> System.out.println(t));

        //query 3.2
//        List<Author> authors = authorService.findAllAuthorsWithBookReleaseDateBefore1990();
//        authors.forEach(a -> System.out.println(String.format("%s %s", a.getFirstName(), a.getLastName())));

        // query 3.3
//        List<Object[]> authorsByBookNumber = authorService.findAllAuthorsByBooksNumber();
//        authorsByBookNumber.forEach(a -> System.out.println(String.format("%s %s - %d books", a[0], a[1], a[2])));

        //query 3.4
//        List<Book> booksByAuthor = bookService.findAllBooksByGeorgePowell();
//        booksByAuthor.forEach(b ->
//                System.out.println(String.format("%s - release date: %s; number of copies: %d", b.getTitle(), b.getReleaseDate(), b.getCopies())));

        //related books
        List<Book> books = bookService.findAll();
        List<Book> threeBooks = books.subList(0, 3);

        threeBooks.get(0).getRelatedBooks().add(threeBooks.get(1));
        threeBooks.get(1).getRelatedBooks().add(threeBooks.get(0));
        threeBooks.get(0).getRelatedBooks().add(threeBooks.get(2));
        threeBooks.get(2).getRelatedBooks().add(threeBooks.get(0));

        //save related books to the database
        for (Book book : threeBooks) {
            bookService.save(book);
        }

        for (Book book : threeBooks) {
            System.out.printf("--%s\n", book.getTitle());
            for (Book relatedBook : book.getRelatedBooks()) {
                System.out.println(relatedBook.getTitle());
            }
        }
    }

    private void seed() throws IOException, ParseException {
        List<Author> authors = new ArrayList<>();
        BufferedReader authorsReader = new BufferedReader(new FileReader("src/authors.txt"));
        String line = authorsReader.readLine();
        while ((line = authorsReader.readLine()) != null) {
            String[] data = line.split("\\s+");
            String firstName = data[0];
            String lastName = data[1];

            Author author = new Author();
            author.setFirstName(firstName);
            author.setLastName(lastName);
            authors.add(author);
            authorService.save(author);
        }

        List<Category> categories = new ArrayList<>();
        BufferedReader categoriesReader = new BufferedReader(new FileReader("src/categories.txt"));
        line = categoriesReader.readLine();
        while ((line = categoriesReader.readLine()) != null) {
            Category category = new Category();
            category.setName(line);
            categories.add(category);
            categoryService.save(category);
        }

        Random random = new Random();
        BufferedReader booksReader = new BufferedReader(new FileReader("src/books.txt"));
        line = booksReader.readLine();
        while ((line = booksReader.readLine()) != null) {
            String[] data = line.split("\\s+");

            int authorIndex = random.nextInt(authors.size());
            Author author = authors.get(authorIndex);
            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
            Date releaseDate = formatter.parse(data[1]);
            int copies = Integer.parseInt(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
            StringBuilder titleBuilder = new StringBuilder();
            for (int i = 5; i < data.length; i++) {
                titleBuilder.append(data[i]).append(" ");
            }
            titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(" "));
            String title = titleBuilder.toString();

            Book book = new Book();
            book.setAuthor(author);
            book.setEditionType(editionType);
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);
            Set<Category> bookCategories = new HashSet<>();
            int count = random.nextInt(categories.size());
            for (int i = 0; i < count; i++) {
                int index = random.nextInt(categories.size());
                bookCategories.add(categories.get(index));
            }

            book.setCategories(bookCategories);
            bookService.save(book);
        }
    }
}
