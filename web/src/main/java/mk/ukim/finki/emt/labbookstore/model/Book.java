package mk.ukim.finki.emt.labbookstore.model;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.emt.labbookstore.model.enumerations.Category;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    private Author author;

    private Integer availableCopies;

    public Book() {
    }

    public Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}