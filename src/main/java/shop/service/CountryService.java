package shop.service;

import shop.entity.Country;

public interface CountryService {
    Country save(Country country);
    Country get(Long id);
    Country remove(Country country);
}
