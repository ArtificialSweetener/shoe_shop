package shop.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.dao.OrderStatusDao;
import shop.entity.OrderStatus;

@Repository
public class OrderStatusDaoImpl implements OrderStatusDao {
    private final SessionFactory sessionFactory;
    @Autowired
    public OrderStatusDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public OrderStatus save(OrderStatus orderStatus) {

        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(orderStatus);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t save order status to DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return orderStatus;
    }

    @Override
    public OrderStatus get(Long id) {

        try (Session session = sessionFactory.openSession()){
            return session.get(OrderStatus.class, id);
        }
    }

    @Override
    public OrderStatus remove(OrderStatus orderStatus) {

        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(orderStatus);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t remove orderStatus from DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return orderStatus;
    }

}
