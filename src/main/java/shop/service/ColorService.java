package shop.service;

import shop.entity.Color;

public interface ColorService {
    Color save(Color color);
    Color get(Long id);
    Color remove(Color color);
}
