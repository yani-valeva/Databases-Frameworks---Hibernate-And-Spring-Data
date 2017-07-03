package bookLibrary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Library library = new Library();
        int bookCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < bookCount; i++) {
            String[] bookInfo = reader.readLine().split("\\s+");
            String title = bookInfo[0];
            String author = bookInfo[1];
            String publisher = bookInfo[2];
            LocalDate releaseDate = LocalDate.parse(bookInfo[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            String isbn = bookInfo[4];
            double price = Double.parseDouble(bookInfo[5]);
            Book book = new Book(title, author, publisher, releaseDate, isbn, price);
            library.getBooks().add(book);
        }

        Map<String, Double> selectedBooks = new HashMap<>();

        for (Book book : library.getBooks()) {
            String currentAuthor = book.getAuthor();
            double currentPrice = book.getPrice();

            if (!selectedBooks.containsKey(currentAuthor)) {
                selectedBooks.put(currentAuthor, currentPrice);
            } else {
                selectedBooks.put(currentAuthor, selectedBooks.get(currentAuthor) + currentPrice);
            }
        }

        selectedBooks.entrySet().stream().sorted((a, b) -> {
            int result = Double.compare(b.getValue(), a.getValue());
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(a -> System.out.printf("%s -> %.2f%n", a.getKey(), a.getValue()));
    }
}
