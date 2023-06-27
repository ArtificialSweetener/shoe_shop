package shop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.dao.OrderDao;
import shop.entity.Order;
import shop.entity.PaymentTransaction;
import shop.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
@Repository
public class OrderDaoImpl implements OrderDao {
    private final SessionFactory sessionFactory;
    @Autowired
    public OrderDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Order save(Order order) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(order);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t save order to DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return order;
    }

    @Override
    public Order get(Long id) {
        try (Session session = sessionFactory.openSession()){
            Query<Order> getOrderQuery =
                    session.createQuery("select distinct o from Order o "
                            + "left join fetch o.products "
                            + "where o.id = :id", Order.class);
            getOrderQuery.setParameter("id", id);

            Order order = getOrderQuery.getSingleResult();

            Query<PaymentTransaction> paymentTransactionQuery =
                    session.createQuery("select pt from Order o "
                                    + "join o.paymentTransactions pt "
                                    + "where o.id = :id", PaymentTransaction.class)
                            .setParameter("id", id);
            List<PaymentTransaction> paymentTransactions = paymentTransactionQuery.list();

            order.setPaymentTransactions(paymentTransactions);

            return order;
        }
    }

    @Override
    public Order remove(Order order) {

        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(order);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t remove order from DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return order;
    }

    @Override
    public List<Order> findAll(User user) {
        try (Session session = sessionFactory.openSession()){
            Query<Order> getOrderQuery =
                    session.createQuery("from Order o "
                            + "left join fetch o.products "
                            + "where o.owner = :owner", Order.class);
            getOrderQuery.setParameter("owner", user);
            return getOrderQuery.getResultList();
        }
    }
}
