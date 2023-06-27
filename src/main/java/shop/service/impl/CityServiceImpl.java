package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dao.CityDao;
import shop.entity.City;
import shop.service.CityService;
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao cityDao;
    @Override
    public City save(City city) {
        return cityDao.save(city);
    }

    @Override
    public City get(Long id) {
        return cityDao.get(id);
    }

    @Override
    public City remove(City city) {
        return cityDao.remove(city);
    }
}
