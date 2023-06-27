package shop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.dao.GenderDao;
import shop.entity.Gender;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Repository
public class GenderDaoImpl implements GenderDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public GenderDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Gender save(Gender gender) {

        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(gender);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t save gender to DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return gender;
    }

    @Override
    public Gender get(Long id) {

        try (Session session = sessionFactory.openSession()){
            return session.get(Gender.class, id);
        }
    }

    @Override
    public Gender remove(Gender gender) {

        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(gender);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t remove gender from DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return gender;
    }
}
