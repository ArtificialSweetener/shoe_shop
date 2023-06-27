package shop.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.dao.PaymentInformationDao;
import shop.entity.PaymentInformation;

@Repository
public class PaymentInformationDaoImpl implements PaymentInformationDao {
    private final SessionFactory sessionFactory;
    @Autowired
    public PaymentInformationDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public PaymentInformation save(PaymentInformation paymentInformation) {

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
            throw new RuntimeException("Can´t save paymentInformation to DB" + e);
        } finally {
            if (session != null){
                session.persist(paymentInformation);

                session.close();
            }
        }
        return paymentInformation;
    }

    @Override
    public PaymentInformation get(Long id) {

        try (Session session = sessionFactory.openSession()){
            return session.get(PaymentInformation.class, id);
        }
    }

    @Override
    public PaymentInformation remove(PaymentInformation paymentInformation) {

        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(paymentInformation);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t remove paymentInformation from DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return paymentInformation;
    }
}
