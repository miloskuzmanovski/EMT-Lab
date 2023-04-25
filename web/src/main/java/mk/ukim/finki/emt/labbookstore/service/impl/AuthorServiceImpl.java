package mk.ukim.finki.emt.labbookstore.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.labbookstore.model.Author;
import mk.ukim.finki.emt.labbookstore.model.Country;
import mk.ukim.finki.emt.labbookstore.model.dto.AuthorDto;
import mk.ukim.finki.emt.labbookstore.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emt.labbookstore.repository.AuthorRepository;
import mk.ukim.finki.emt.labbookstore.service.AuthorService;
import mk.ukim.finki.emt.labbookstore.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryService countryService;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryService countryService) {
        this.authorRepository = authorRepository;
        this.countryService = countryService;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return Optional.of(this.authorRepository
                .findById(id).orElseThrow(() -> new AuthorNotFoundException(id)));
    }

//    @Override
//    public Optional<Author> create(String name, String surname, Long countryId) {
//        Country country = this.countryService.findById(countryId);
//        Author author = new Author(name, surname, country);
//        return Optional.of(this.authorRepository.save(author));
//    }

    @Override
    public Optional<Author> create(Author author) {
        return Optional.of(this.authorRepository.save(author));
    }
}
