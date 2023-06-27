package shop.dao;

import shop.entity.City;

public interface CityDao {
    City save(City city);
    City get(Long id);
    City remove(City city);
}
