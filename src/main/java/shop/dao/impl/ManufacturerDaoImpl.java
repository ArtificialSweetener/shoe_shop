package shop.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.dao.ManufacturerDao;
import shop.entity.Manufacturer;

@Repository
public class ManufacturerDaoImpl implements ManufacturerDao {
    private final SessionFactory sessionFactory;
    @Autowired
    public ManufacturerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Manufacturer save(Manufacturer manufacturer) {

        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(manufacturer);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t save manufacturer to DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return manufacturer;
    }

    @Override
    public Manufacturer get(Long id) {

        try (Session session = sessionFactory.openSession()){
            return session.get(Manufacturer.class, id);
        }
    }

    @Override
    public Manufacturer remove(Manufacturer manufacturer) {

        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(manufacturer);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t remove manufacturer from DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return manufacturer;
    }
}
