package mk.ukim.finki.emt.labbookstore.controller;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.labbookstore.model.Book;
import mk.ukim.finki.emt.labbookstore.model.dto.BookDto;
import mk.ukim.finki.emt.labbookstore.model.enumerations.Category;
import mk.ukim.finki.emt.labbookstore.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/categories")
    public List<Category> findAllCategories() {
        List<Category> categories = Arrays.asList(Category.values());
        return categories;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return this.bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto) {
        return this.bookService.save(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/editBook/{id}")
    public ResponseEntity<Book> edit(@PathVariable Long id, @RequestBody BookDto bookDto) {
        return this.bookService.edit(id, bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Book> deleteById(@PathVariable Long id) {
        return this.bookService.delete(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/setAvailableCopies/{id}")
    public ResponseEntity<Book> setAvailableCopies(@PathVariable Long id) {
        return this.bookService.setAvailableCopies(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.noContent().build());
    }
}
