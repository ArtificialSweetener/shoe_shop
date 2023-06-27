package shop.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.dao.CityDao;
import shop.entity.City;

@Repository
public class CityDaoImpl implements CityDao {
    private final SessionFactory sessionFactory;
    @Autowired
    public CityDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public City save(City city) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(city);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t save city to DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return city;
    }

    @Override
    public City get(Long id) {
        try (Session session = sessionFactory.openSession()){
            return session.get(City.class, id);
        }
    }

    @Override
    public City remove(City city) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(city);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t remove city from DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return city;
    }
}
