package shop.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.dao.DeliveryInformationDao;
import shop.entity.DeliveryInformation;

@Repository
public class DeliveryInformationDaoImpl implements DeliveryInformationDao {
    private final SessionFactory sessionFactory;
    @Autowired
    public DeliveryInformationDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public DeliveryInformation save(DeliveryInformation deliveryInformation) {

        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(deliveryInformation);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t save deliveryInformation to DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return deliveryInformation;
    }

    @Override
    public DeliveryInformation get(Long id) {

        try (Session session = sessionFactory.openSession()){
            return session.get(DeliveryInformation.class, id);
        }
    }

    @Override
    public DeliveryInformation remove(DeliveryInformation deliveryInformation) {

        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(deliveryInformation);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t remove deliveryInformation from DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return deliveryInformation;
    }
}
