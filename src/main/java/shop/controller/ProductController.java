package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.entity.Product;
import shop.service.ProductService;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public String getProductFromDB() {
        if (productService.findAll().isEmpty()) return "No products in this db";
        return "There are products in this db";
    }
    @GetMapping("/pricegreater")
    public String getProductWithPriceGreaterThen100() {
        if (productService.findAllWherePriceGreaterThan(100.0).isEmpty()) return "No products in this db that have price greater than 100.0";
        return "There are products in this db that have price greater than 100.0";
    }

    @GetMapping("/product2")
    public List<Product> getProductFromDB2() {
        return productService.findAll();
    }
}
