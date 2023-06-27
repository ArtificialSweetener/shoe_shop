package shop.service;

import shop.entity.Size;

public interface SizeService {
    Size save(Size size);
    Size get(Long id);
    Size remove(Size size);
}
