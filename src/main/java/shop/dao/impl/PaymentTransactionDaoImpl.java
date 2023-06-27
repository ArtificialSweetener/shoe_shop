package shop.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.dao.PaymentTransactionDao;
import shop.entity.PaymentTransaction;

@Repository
public class PaymentTransactionDaoImpl implements PaymentTransactionDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public PaymentTransactionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public PaymentTransaction save(PaymentTransaction paymentTransaction) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(paymentTransaction);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t save payment transaction to DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return paymentTransaction;
    }

    @Override
    public PaymentTransaction get(Long id) {
        try (Session session = sessionFactory.openSession()){
            return session.get(PaymentTransaction.class, id);
        }
    }

    @Override
    public PaymentTransaction remove(PaymentTransaction paymentTransaction) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(paymentTransaction);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t remove payment transaction from DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return paymentTransaction;
    }
}
