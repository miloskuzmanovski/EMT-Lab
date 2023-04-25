package mk.ukim.finki.emt.labbookstore.repository;

import mk.ukim.finki.emt.labbookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
