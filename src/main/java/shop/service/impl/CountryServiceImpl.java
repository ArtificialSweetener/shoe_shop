package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dao.CountryDao;
import shop.entity.Country;
import shop.service.CountryService;
@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryDao countryDao;
    @Override
    public Country save(Country country) {
        return countryDao.save(country);
    }

    @Override
    public Country get(Long id) {
        return countryDao.get(id);
    }

    @Override
    public Country remove(Country country) {
        return countryDao.remove(country);
    }
}
