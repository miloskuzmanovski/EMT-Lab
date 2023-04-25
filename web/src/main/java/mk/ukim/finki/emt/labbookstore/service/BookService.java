package mk.ukim.finki.emt.labbookstore.service;

import mk.ukim.finki.emt.labbookstore.model.Book;
import mk.ukim.finki.emt.labbookstore.model.dto.BookDto;
import mk.ukim.finki.emt.labbookstore.model.enumerations.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> create(String name, Category category, Long authorId, Integer availableCopies);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long id, BookDto bookDto);

    Optional<Book> delete(Long id);

    Optional<Book> setAvailableCopies(Long id);
}