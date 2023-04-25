package mk.ukim.finki.emt.labbookstore.repository;

import mk.ukim.finki.emt.labbookstore.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
