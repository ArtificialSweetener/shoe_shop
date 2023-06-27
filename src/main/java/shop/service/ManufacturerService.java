package shop.service;

import shop.entity.Manufacturer;

public interface ManufacturerService {
    Manufacturer save(Manufacturer manufacturer);
    Manufacturer get(Long id);
    Manufacturer remove(Manufacturer manufacturer);
}
