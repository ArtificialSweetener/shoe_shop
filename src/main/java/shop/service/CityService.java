package shop.service;

import shop.entity.City;

public interface CityService {
    City save(City city);
    City get(Long id);
    City remove(City city);
}
