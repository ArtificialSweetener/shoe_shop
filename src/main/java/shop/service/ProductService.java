package shop.service;

import shop.entity.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    Product get(Long id);
    List<Product> findAll();
    List<Product> findAllWherePriceGreaterThan(Double price);
}
