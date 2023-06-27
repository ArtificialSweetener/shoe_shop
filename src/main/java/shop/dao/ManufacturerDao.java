package shop.dao;

import shop.entity.Manufacturer;

public interface ManufacturerDao {
    Manufacturer save(Manufacturer manufacturer);
    Manufacturer get(Long id);
    Manufacturer remove(Manufacturer manufacturer);
}
