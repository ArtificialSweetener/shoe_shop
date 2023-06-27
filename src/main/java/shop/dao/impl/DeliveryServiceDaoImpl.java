package shop.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.dao.DeliveryServiceDao;
import shop.entity.DeliveryService;

@Repository
public class DeliveryServiceDaoImpl implements DeliveryServiceDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public DeliveryServiceDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public DeliveryService save(DeliveryService deliveryService) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(deliveryService);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t save deliveryService to DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return deliveryService;
    }

    @Override
    public DeliveryService get(Long id) {

        try (Session session = sessionFactory.openSession()){
            return session.get(DeliveryService.class, id);
        }
    }

    @Override
    public DeliveryService remove(DeliveryService deliveryService) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(deliveryService);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t remove deliveryService from DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return deliveryService;
    }
}
