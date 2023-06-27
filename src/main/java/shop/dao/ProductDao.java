package shop.dao;

import shop.entity.Product;

import java.util.List;

public interface ProductDao {
    Product save(Product product);
    Product get(Long id);
    Product remove(Product product);
    List<Product> findAll();
    List<Product> findAllWherePriceGreaterThan(Double price);
    List<Product> findAllWherePriceBetween(Double from, Double to);
    List<Product> findAllWherePriceBetweenAndColorIn(Double from, Double to, String [] colors);
    List<Product> findAllWherePriceBetweenOrColorIn(Double from, Double to, String [] colors);
}
