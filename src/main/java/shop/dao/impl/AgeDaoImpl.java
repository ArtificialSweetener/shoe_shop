package shop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.dao.AgeDao;
import shop.entity.Age;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Repository
public class AgeDaoImpl implements AgeDao {
    private final SessionFactory sessionFactory;
    @Autowired
    public AgeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Age save(Age age) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(age);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t save age to DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return age;
    }

    @Override
    public Age get(Long id) {
        try (Session session = sessionFactory.openSession()){
            return session.get(Age.class, id);
        }
    }

    @Override
    public Age remove(Age age) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(age);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t remove age from DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return age;
    }
}
