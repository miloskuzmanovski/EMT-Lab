package mk.ukim.finki.emt.labbookstore.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.emt.labbookstore.model.Author;
import mk.ukim.finki.emt.labbookstore.model.Country;
import mk.ukim.finki.emt.labbookstore.service.AuthorService;
import mk.ukim.finki.emt.labbookstore.service.BookService;
import mk.ukim.finki.emt.labbookstore.service.CountryService;
import org.springframework.stereotype.Component;

import static mk.ukim.finki.emt.labbookstore.model.enumerations.Category.*;

@Component
public class DataInitializer {

    private final AuthorService authorService;
    private final CountryService countryService;
    private final BookService bookService;

    public DataInitializer(AuthorService authorService, CountryService countryService, BookService bookService) {
        this.authorService = authorService;
        this.countryService = countryService;
        this.bookService = bookService;
    }

    @PostConstruct
    public void initData() {
        Country country = new Country("Macedonia", "Europe");
        Country country1 = new Country("Germany", "Europe");
        Country country2 = new Country("UK", "Europe");
        Country country3 = new Country("France", "Europe");

        countryService.create(country);
        countryService.create(country1);
        countryService.create(country2);
        countryService.create(country3);

        Author author1 = new Author("Charles", "Darwin", country);
        Author author2 = new Author("Jules", "Verne", country1);
        Author author3 = new Author("Lucy", "Foley", country2);
        Author author4 = new Author("Ernest", "Hemingway", country);
        Author author5 = new Author("Arthur Conan", "Doyle", country1);
        Author author6 = new Author("Lewis", "Carrol", country2);
        Author author7 = new Author("Boris", "Pasternak", country);
        Author author8 = new Author("Sarah", "J.Maas", country1);
        Author author9 = new Author("Ellery", "Lloyd", country2);
        Author author10 = new Author("Graham", "Greene", country2);
        Author author11 = new Author("Dante", "Alighieri", country3);
        Author author12 = new Author("Walker", "Percy", country2);

        authorService.create(author1);
        authorService.create(author2);
        authorService.create(author3);
        authorService.create(author4);
        authorService.create(author5);
        authorService.create(author6);
        authorService.create(author7);
        authorService.create(author8);
        authorService.create(author9);
        authorService.create(author10);
        authorService.create(author11);
        authorService.create(author12);

        this.bookService.create("A Tale of Two Cities", NOVEL, author1.getId(), 2);
        this.bookService.create("Around the World in Eighty Days", THRILLER, author2.getId(), 4);
        this.bookService.create("Alice in Wonderland", NOVEL, author6.getId(), 1);
        this.bookService.create("Dr. Zhivago", NOVEL, author7.getId(), 1);
        this.bookService.create("House of Sky and Breath", NOVEL, author8.getId(), 1);
        this.bookService.create("The Club", NOVEL, author9.getId(), 1);
        this.bookService.create("Divine Comedy", DRAMA, author11.getId(), 13);
        this.bookService.create("The Moviegoer", DRAMA, author12.getId(), 9);
        this.bookService.create("The Paris Apartment", FANTASY, author3.getId(), 5);
        this.bookService.create("Old Man and the Sea", DRAMA, author4.getId(), 8);
        this.bookService.create("Adventures of Sherlock Holmes", THRILLER, author5.getId(), 6);

    }
}
