package shop.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.dao.CountryDao;
import shop.entity.Country;

@Repository
public class CountryDaoImpl implements CountryDao {
    private final SessionFactory sessionFactory;
    @Autowired
    public CountryDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Country save(Country country) {

        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(country);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t save country to DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return country;
    }

    @Override
    public Country get(Long id) {
        try (Session session = sessionFactory.openSession()){
            return session.get(Country.class, id);
        }
    }

    @Override
    public Country remove(Country country) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(country);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t remove country from DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return country;
    }
}
