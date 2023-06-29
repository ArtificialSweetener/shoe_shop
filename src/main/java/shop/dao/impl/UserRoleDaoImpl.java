package shop.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.dao.UserRoleDao;
import shop.entity.UserRole;

@Repository
public class UserRoleDaoImpl implements UserRoleDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public UserRoleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public UserRole save(UserRole userRole) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(userRole);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t save user role to DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return userRole;
    }

    @Override
    public UserRole get(Long id) {
        try (Session session = sessionFactory.openSession()){
            return session.get(UserRole.class, id);
        }
    }

    @Override
    public UserRole remove(UserRole userRole) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(userRole);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t remove userRole from DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return userRole;
    }
}
