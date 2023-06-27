package shop.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {
    private static final EntityManagerFactory entityManagerFactory= initEntityManagerFactory();

    private static EntityManagerFactory initEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("ShoeShopPU");
    }
    public static EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }

}
