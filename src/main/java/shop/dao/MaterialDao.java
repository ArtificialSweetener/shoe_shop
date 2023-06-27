package shop.dao;

import shop.entity.Material;

public interface MaterialDao {
    Material save(Material material);
    Material get(Long id);
    Material remove(Material material);
}
