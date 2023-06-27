package shop.dao;

import shop.entity.Category;

public interface CategoryDao {
    Category save(Category category);
    Category get(Long id);
    Category remove(Category category);
}
