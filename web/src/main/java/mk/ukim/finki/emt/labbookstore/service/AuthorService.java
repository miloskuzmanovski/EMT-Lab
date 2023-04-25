package mk.ukim.finki.emt.labbookstore.service;

import mk.ukim.finki.emt.labbookstore.model.Author;
import mk.ukim.finki.emt.labbookstore.model.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();

    Optional<Author> findById(Long id);

    Optional<Author> create(Author author);
}
