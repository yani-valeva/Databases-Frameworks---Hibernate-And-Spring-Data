package bookStore;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Book> books = Stream.of(new Book("Vinetu3", 20, "Karl Mai"),
                new Book("Vinetu1", 20, "Karl Mai"),
                new Book("Vinetu2", 15, "Karl Mai"),
                new Book("Sherlock Holmes", 12, "Arthur C. Doyl"),
                new Book("The Lost World", 43, "Arthur C. Doyl"),
                new Book ("Hunger games", 150, "Suzan Colins"));

        books.collect(
                Collectors.groupingBy(Book::getAuthor,
                        Collectors.summingDouble(Book::getPrice)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.<String, Double>comparingByKey()))
                .forEach(System.out::println);
    }
}
