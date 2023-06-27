package shop.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.dao.CategoryDao;
import shop.entity.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {
    private final SessionFactory sessionFactory;
    @Autowired
    public CategoryDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Category save(Category category) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(category);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t save category to DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return category;
    }

    @Override
    public Category get(Long id) {
        try (Session session = sessionFactory.openSession()){
            return session.get(Category.class, id);
        }
    }

    @Override
    public Category remove(Category category) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(category);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t remove category from DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return category;
    }
}
