package mk.ukim.finki.emt.labbookstore.service;

import mk.ukim.finki.emt.labbookstore.model.Country;
import mk.ukim.finki.emt.labbookstore.model.dto.CountryDto;

import java.util.List;

public interface CountryService {
    Country findById(Long id);

    Country create(Country country);
}