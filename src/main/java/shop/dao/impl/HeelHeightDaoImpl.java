package shop.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.dao.HeelHeightDao;
import shop.entity.HeelHeight;

@Repository
public class HeelHeightDaoImpl implements HeelHeightDao {
    private final SessionFactory sessionFactory;
    @Autowired
    public HeelHeightDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public HeelHeight save(HeelHeight heelHeight) {

        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(heelHeight);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t save heel height to DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return heelHeight;
    }

    @Override
    public HeelHeight get(Long id) {

        try (Session session = sessionFactory.openSession()){
            return session.get(HeelHeight.class, id);
        }
    }

    @Override
    public HeelHeight remove(HeelHeight heelHeight) {

        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(heelHeight);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t remove heelHeight from DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return heelHeight;
    }
}
