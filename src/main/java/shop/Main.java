package shop;

import shop.config.AppConfig;

import shop.entity.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shop.service.ProductService;

public class Main {
    public static void main(String[] args) {
       Product iPhone = new Product();
       iPhone.setName("iPhone X");
       iPhone.setPrice(999.0);

       Product samsung = new Product();
       samsung.setName("Samsung S20");
       samsung.setPrice(695.0);

       Product samsung10 = new Product();
       samsung10.setName("Samsung S10");
       samsung10.setPrice(600.0);

       AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
       ProductService productService = context.getBean(ProductService.class);

       productService.save(iPhone);
       productService.save(samsung);
       productService.save(samsung10);

       System.out.println(productService.findAll());

    }

}
