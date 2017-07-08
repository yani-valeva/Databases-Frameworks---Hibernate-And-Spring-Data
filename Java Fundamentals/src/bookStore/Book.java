package bookStore;

public class Book {
    private String name;
    private double price;
    private String author;

    public Book(String name, double price, String author) {
        this.setName(name);
        this.setPrice(price);
        this.setAuthor(author);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
