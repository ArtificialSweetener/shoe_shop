package shop.dao;

import shop.entity.Color;

public interface ColorDao {
    Color save(Color color);
    Color get(Long id);
    Color remove(Color color);
}
