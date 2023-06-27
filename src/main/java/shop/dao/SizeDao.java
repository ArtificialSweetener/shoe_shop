package shop.dao;

import shop.entity.Size;

public interface SizeDao {
    Size save(Size size);
    Size get(Long id);
    Size remove(Size size);
}
