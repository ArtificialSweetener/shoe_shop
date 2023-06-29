package shop.dao.impl;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.dao.ProductDao;
import shop.entity.Product;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public ProductDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Product save(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t save product to DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return product;
    }

    @Override
    public Product get(Long id) {
        try (Session session = sessionFactory.openSession()){
            return session.get(Product.class, id);
        }
    }

    @Override
    public Product remove(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(product);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t remove product from DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        try (Session session = sessionFactory.openSession()){
            Query<Product> getAllProductsQuery = session.createQuery("from Product", Product.class);
            return getAllProductsQuery.getResultList();
        }
    }

    @Override
    public List<Product> findAllWherePriceGreaterThan(Double price) {
        try (Session session = sessionFactory.openSession()){
            Query<Product> getAllProductsQuery = session.createQuery("from Product p where p.price > :value", Product.class);
            getAllProductsQuery.setParameter("value", price);
            return getAllProductsQuery.getResultList();
        }
    }

    @Override
    public List<Product> findAllWherePriceBetween(Double from, Double to) {
        try(Session session = sessionFactory.openSession()){
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Product> query = cb.createQuery(Product.class);
            Root<Product> productRoot = query.from(Product.class);
            Predicate priceGt = cb.gt(productRoot.get("price"), from);
            Predicate priceLt = cb.gt(productRoot.get("price"), to);
            //select from products where price > :from and price <: to
            Predicate pricePredicate = cb.and(priceGt, priceLt);
            query.where(pricePredicate);
            return session.createQuery(query).getResultList();
        }
    }


    @Override
    public List<Product> findAllWherePriceBetweenAndColorIn(Double from, Double to, String[] colors) {
        try(Session session = sessionFactory.openSession()){
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Product> query = cb.createQuery(Product.class);
            Root<Product> productRoot = query.from(Product.class);
            // where price > :from and price <: to and color in (red, black, white)

            //price predicate
            Predicate priceGt = cb.gt(productRoot.get("price"), from);
            Predicate priceLt = cb.gt(productRoot.get("price"), to);
            Predicate pricePredicate = cb.and(priceGt, priceLt);

            //color predicate
            CriteriaBuilder.In<String> colorPredicate = cb.in(productRoot.get("color"));
            for(String color: colors){
                colorPredicate.value(color);
            }

            query.where(cb.and(pricePredicate, colorPredicate));
            return session.createQuery((query)).getResultList();
        }
    }

    @Override
    public List<Product> findAllWherePriceBetweenOrColorIn(Double from, Double to, String[] colors) {
        try(Session session = sessionFactory.openSession()){
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Product> query = cb.createQuery(Product.class);
            Root<Product> productRoot = query.from(Product.class);
            // where price > :from and price <: to or color in (red, black, white)

            //price predicate
            Predicate priceGt = cb.gt(productRoot.get("price"), from);
            Predicate priceLt = cb.gt(productRoot.get("price"), to);
            Predicate pricePredicate = cb.and(priceGt, priceLt);

            //color predicate
            CriteriaBuilder.In<String> colorPredicate = cb.in(productRoot.get("color"));
            for(String color: colors){
                colorPredicate.value(color);
            }

            query.where(cb.or(pricePredicate, colorPredicate));
            return session.createQuery((query)).getResultList();
        }
    }
}
