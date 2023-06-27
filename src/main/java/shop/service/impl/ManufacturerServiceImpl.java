package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dao.ManufacturerDao;
import shop.entity.Manufacturer;
import shop.service.ManufacturerService;
@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Autowired
    private ManufacturerDao manufacturerDao;
    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        return manufacturerDao.save(manufacturer);
    }

    @Override
    public Manufacturer get(Long id) {
        return manufacturerDao.get(id);
    }

    @Override
    public Manufacturer remove(Manufacturer manufacturer) {
        return manufacturerDao.remove(manufacturer);
    }
}
