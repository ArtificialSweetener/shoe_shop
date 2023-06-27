package shop.dao.impl;

import org.hibernate.SessionFactory;
import shop.dao.ProductDao;
import shop.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import shop.util.EntityManagerUtil;

import java.util.List;

public class JpaProductDaoImpl implements ProductDao {
    @Override
    public Product save(Product product) {
        EntityManagerFactory entityManagerFactory = EntityManagerUtil.getEntityManagerFactory() ;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            transaction= entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(product);
            transaction.commit();
        }catch (Exception e){
            if (transaction!=null){
               transaction.rollback();
            }
            throw new RuntimeException("Can´t save product to DB", e);
        }finally {
            if (entityManager !=null){
                entityManager.close();
            }
        }
        return product;
    }

    @Override
    public Product get(Long id) {
        return null;
    }

    @Override
    public Product remove(Product product) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public List<Product> findAllWherePriceGreaterThan(Double price) {
        return null;
    }

    @Override
    public List<Product> findAllWherePriceBetween(Double from, Double to) {
        return null;
    }

    @Override
    public List<Product> findAllWherePriceBetweenAndColorIn(Double from, Double to, String[] colors) {
        return null;
    }

    @Override
    public List<Product> findAllWherePriceBetweenOrColorIn(Double from, Double to, String[] colors) {
        return null;
    }
}
