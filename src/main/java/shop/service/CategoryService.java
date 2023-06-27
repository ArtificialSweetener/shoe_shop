package shop.service;

import shop.entity.Category;

public interface CategoryService {
    Category save(Category category);
    Category get(Long id);
    Category remove(Category category);
}
