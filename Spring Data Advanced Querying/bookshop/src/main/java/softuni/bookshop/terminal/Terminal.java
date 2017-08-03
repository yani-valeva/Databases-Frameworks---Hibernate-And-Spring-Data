package softuni.bookshop.terminal;

import org.aspectj.weaver.bcel.BcelFieldRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import softuni.bookshop.entities.Author;
import softuni.bookshop.entities.Book;
import softuni.bookshop.entities.Category;
import softuni.bookshop.entities.ReducedBook;
import softuni.bookshop.enums.AgeRestriction;
import softuni.bookshop.enums.EditionType;
import softuni.bookshop.repositories.AuthorRepository;
import softuni.bookshop.repositories.BookRepository;
import softuni.bookshop.services.AuthorService;
import softuni.bookshop.services.BookService;
import softuni.bookshop.services.CategoryService;

import java.awt.image.DataBufferByte;
import java.io.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 1. Book titles by age restriction
        String input = reader.readLine();
        AgeRestriction ageRestriction = AgeRestriction.valueOf(input.toUpperCase());
        List<Book> books = this.bookService.findAllByAgeRestriction(ageRestriction);

        for (Book book : books) {
            System.out.println(book.getTitle());
        }

        // 2. Golden books
//        List<Book> books = this.bookService.findByEditionAndCopies();
//
//        for (Book book : books) {
//            System.out.println(book.getTitle());
//        }

        // 3. Books by price
//        List<Book> books = this.bookService.findAllBooksWithPriceLessThan5OrMoreThan40();
//
//        for (Book book : books) {
//            System.out.println(String.format("%s - $%s", book.getTitle(), book.getPrice()));
//        }

        // 4. not released books
//        int year = Integer.parseInt(reader.readLine());
//        List<Book> books = bookService.findBooksByReleaseDateNotIn(year);
//
//        for (Book book : books) {
//            System.out.println(book.getTitle());
//        }

        // 5. Book titles by category
//        String[] input = reader.readLine().split("\\s+");
//        List<Category> categories = this.categoryService.findByNameIn(input);
//        List<Book> books = this.bookService.findByCategoriesIn(categories);
//
//        for (Book book : books) {
//            System.out.println(book.getTitle());
//        }

        // 6. Books Released Before Date
//        String dateAsString = reader.readLine();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        Date date = simpleDateFormat.parse(dateAsString);
//        List<Book> books = this.bookService.findByReleaseDateBefore(date);
//
//        for (Book book : books) {
//            System.out.println(String.format("Title: %s, Edition type: %s, Price: %s", book.getTitle(), book.getEditionType(), book.getPrice()));
//        }

        // 7. Authors search
//        String pattern = reader.readLine();
//        List<Author> authors = this.authorService.findAllByFirstNameEndsWith(pattern);
//
//        for (Author author : authors) {
//            System.out.println(String.format("%s %s", author.getFirstName(), author.getLastName()));
//        }

        // 8. Books search
//        String pattern = reader.readLine();
//        List<Book> books = this.bookService.findAllByTitleContains(pattern);
//
//        for (Book book : books) {
//            System.out.println(book.getTitle());
//        }

        // 9. Book titles search
//        String pattern = reader.readLine();
//        List<Book> books = this.bookService.findAllBooksByAuthorLastNameStartsWith(pattern);
//
//        for (Book book : books) {
//            System.out.println(String.format("%s (%s %s)", book.getTitle(), book.getAuthor().getFirstName(), book.getAuthor().getLastName()));
//        }

        // 10. Count books
//        Integer input = Integer.parseInt(reader.readLine());
//        Integer count = this.bookService.getCountByTitleLength(input);
//        System.out.println(count);

        // 11. Total book copies
//        List<Object[]> booksAndCopies = this.bookService.findSumOfBookCopiesByAuthor();
//
//        for (Object[] booksAndCopy : booksAndCopies) {
//            System.out.println(String.format("%s %s – %s", booksAndCopy[0], booksAndCopy[1], booksAndCopy[2]));
//        }

        // 12. Find profit
//        List<Object[]> objects = this.categoryService.findTotalProfitOfBooksByCategory();
//
//        for (Object[] object : objects) {
//            System.out.println(String.format("%s - $%s", object[0], object[1]));
//        }

        // 13. Most recent books
//        List<Object[]> categoriesAndCount = this.bookService.findCountOfBooksByCategory();
//
//        for (Object[] object : categoriesAndCount) {
//            Category category = (Category) object[0];
//            Long count = (Long) object[1];
//            System.out.println(String.format("--%s: %d books", category.getName(), count));
//
//            List<Book> books = this.bookService.findTop3ByCategoriesOrderByReleaseDateDescTitleAsc(category);
//
//            for (Book book : books) {
//                String title = book.getTitle();
//                String year = new SimpleDateFormat("yyyy").format(book.getReleaseDate());
//                System.out.println(String.format("%s (%s)", title, year));
//            }
//        }

        // 14. Reduced book
//        String title = reader.readLine();
//        ReducedBook reducedBook = this.bookService.findReducedBooksByTitle(title);
//        if (reducedBook != null) {
//            System.out.println(String.format("%s %s %s %s", reducedBook.getTitle(), reducedBook.getEditionType(), reducedBook.getAgeRestriction(), reducedBook.getPrice()));
//        }

        // 15. Increase book copies
//        String dateAsString = reader.readLine();
//        Integer copiesNumber = Integer.parseInt(reader.readLine());
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);
//        LocalDate localDate = LocalDate.parse(dateAsString, formatter);
//        Date date = java.sql.Date.valueOf(localDate);
//        Integer updatedRows = this.bookService.updateBookCopiesAfterGivenDate(copiesNumber, date);
//        System.out.println(updatedRows * copiesNumber);

        // 16. Remove Books
//        Integer number = Integer.parseInt(reader.readLine());
//        Integer removedBooks = this.bookService.removeBooksWithCopiesLowerThan(number);
//        System.out.println(removedBooks == 1 ? String.format("%d book was deleted", removedBooks) : String.format("%d books were deleted", removedBooks));


        // seed data into Db -----> FROM PREVIOUS HOMEWORK
//        seed();

        //related books ----->  FROM PREVIOUS HOMEWORK
//        List<Book> books = bookService.findAll();
//        List<Book> threeBooks = books.subList(0, 3);
//
//        threeBooks.get(0).getRelatedBooks().add(threeBooks.get(1));
//        threeBooks.get(1).getRelatedBooks().add(threeBooks.get(0));
//        threeBooks.get(0).getRelatedBooks().add(threeBooks.get(2));
//        threeBooks.get(2).getRelatedBooks().add(threeBooks.get(0));

        //save related books to the database ----->  FROM PREVIOUS HOMEWORK
//        for (Book book : threeBooks) {
//            bookService.save(book);
//        }
//
//        for (Book book : threeBooks) {
//            System.out.printf("--%s\n", book.getTitle());
//            for (Book relatedBook : book.getRelatedBooks()) {
//                System.out.println(relatedBook.getTitle());
//            }
//        }
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
