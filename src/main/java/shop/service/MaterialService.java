package shop.service;

import shop.entity.Material;

public interface MaterialService {
    Material save(Material material);
    Material get(Long id);
    Material remove(Material material);
}
