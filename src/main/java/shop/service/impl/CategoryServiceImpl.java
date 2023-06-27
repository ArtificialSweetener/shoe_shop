package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dao.CategoryDao;
import shop.entity.Category;
import shop.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Override
    public Category save(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public Category get(Long id) {
        return categoryDao.get(id);
    }

    @Override
    public Category remove(Category category) {
        return categoryDao.remove(category);
    }
}
