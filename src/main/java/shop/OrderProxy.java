package shop;

import shop.entity.Order;
import shop.entity.Product;
import org.hibernate.LazyInitializationException;

import java.util.List;

public class OrderProxy extends Order {
    private List<Product> products = null;
    boolean isSessionOpen=false;
    @Override
    public List<Product> getProducts() {
        if (products!=null){
            return products;
        }
        if (isSessionOpen){
            products=initProducts();
            return products;
        }
        throw new LazyInitializationException("Can´t initializa collection products - no session");
    }
    private List<Product> initProducts(){
        //hiberanate knows how to initialize this collection
        return null;
    }
}
