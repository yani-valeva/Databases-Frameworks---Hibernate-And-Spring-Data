package softuni.bookshop.entities;

import softuni.bookshop.enums.AgeRestriction;
import softuni.bookshop.enums.EditionType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book implements ReducedBook{
    private Long id;
    private String title;
    private String description;
    private EditionType editionType;
    private BigDecimal price;
    private Integer copies;
    private Date releaseDate;
    private AgeRestriction ageRestriction;
    private Author author;
    private Set<Category> categories;
    private Set<Book> relatedBooks;


    public Book() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "title", length = 50, nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description", columnDefinition = "TEXT", length = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "edition_type", nullable = false)
    public EditionType getEditionType() {
        return editionType;
    }

    public void setEditionType(EditionType editionType) {
        this.editionType = editionType;
    }

    @Column(name = "price", nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "copies", nullable = false)
    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    @Column(name = "release_date")
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "age_restriction", nullable = false)
    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @ManyToMany
    @JoinTable(name = "books_categories",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }


    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinTable(name = "related_books",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "related_id", referencedColumnName = "id"))
    public Set<Book> getRelatedBooks() {
        return relatedBooks;
    }

    public void setRelatedBooks(Set<Book> relatedBooks) {
        this.relatedBooks = relatedBooks;
    }
}
