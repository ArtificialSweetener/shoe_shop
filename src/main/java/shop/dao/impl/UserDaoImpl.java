package shop.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.dao.UserDao;
import shop.entity.User;

import java.util.Optional;
@Repository
public class UserDaoImpl implements UserDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User save(User user) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t save user to DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return user;
    }

    @Override
    public User get(Long id) {
        try (Session session = sessionFactory.openSession()){
            return session.get(User.class, id);
        }
    }

    @Override
    public User remove(User user) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(user);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t remove user from DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return user;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (Session session = sessionFactory.openSession()){
            return session.createQuery("from User u where u.email = :email", User.class)
                    .setParameter("email", email)
                    .uniqueResultOptional();
        }
    }
}
