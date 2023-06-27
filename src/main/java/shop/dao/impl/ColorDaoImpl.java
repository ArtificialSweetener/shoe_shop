package shop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.dao.ColorDao;
import shop.entity.Color;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Repository
public class ColorDaoImpl implements ColorDao {
    private final SessionFactory sessionFactory;
    @Autowired
    public ColorDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Color save(Color color) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(color);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t save color to DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return color;
    }

    @Override
    public Color get(Long id) {
        try (Session session = sessionFactory.openSession()){
            return session.get(Color.class, id);
        }
    }

    @Override
    public Color remove(Color color) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(color);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t remove color from DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return color;
    }
}
