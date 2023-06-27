package shop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.dao.PaymentServiceDao;
import shop.entity.PaymentService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Repository
public class PaymentServiceDaoImpl implements PaymentServiceDao {
    private final SessionFactory sessionFactory;
    @Autowired
    public PaymentServiceDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public PaymentService save(PaymentService paymentService) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t save payment service to DB" + e);
        } finally {
            if (session != null){
                session.persist(paymentService);
                session.close();
            }
        }
        return paymentService;
    }

    @Override
    public PaymentService get(Long id) {
        try (Session session = sessionFactory.openSession()){
            return session.get(PaymentService.class, id);
        }
    }

    @Override
    public PaymentService remove(PaymentService paymentService) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(paymentService);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t remove paymentService from DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return paymentService;
    }
}
