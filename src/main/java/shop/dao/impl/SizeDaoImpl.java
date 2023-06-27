package shop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.dao.SizeDao;
import shop.entity.Size;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Repository
public class SizeDaoImpl implements SizeDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public SizeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Size save(Size size) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(size);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t save size to DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return size;
    }

    @Override
    public Size get(Long id) {
        try (Session session = sessionFactory.openSession()){
            return session.get(Size.class, id);
        }
    }

    @Override
    public Size remove(Size size) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(size);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t remove size from DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return size;
    }
}
