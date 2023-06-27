package shop.dao;

import shop.entity.Country;

public interface CountryDao {
    Country save(Country country);
    Country get(Long id);
    Country remove(Country country);
}
