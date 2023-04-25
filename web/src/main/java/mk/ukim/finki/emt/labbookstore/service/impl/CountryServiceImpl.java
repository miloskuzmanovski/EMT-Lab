package mk.ukim.finki.emt.labbookstore.service.impl;

import mk.ukim.finki.emt.labbookstore.model.Country;
import mk.ukim.finki.emt.labbookstore.model.dto.CountryDto;
import mk.ukim.finki.emt.labbookstore.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.emt.labbookstore.repository.CountryRepository;
import mk.ukim.finki.emt.labbookstore.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country findById(Long id) {
        return this.countryRepository.findById(id).orElseThrow(() -> new CountryNotFoundException(id));
    }

    @Override
    public Country create(Country country) {
        return this.countryRepository.save(country);
    }
}