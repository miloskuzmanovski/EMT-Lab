package mk.ukim.finki.emt.labbookstore.repository;

import mk.ukim.finki.emt.labbookstore.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
