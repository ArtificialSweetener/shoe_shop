package shop.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.dao.MaterialDao;
import shop.entity.Material;

@Repository
public class MaterialDaoImpl implements MaterialDao {
    private final SessionFactory sessionFactory;
    @Autowired
    public MaterialDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Material save(Material material) {

        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(material);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t save material to DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return material;
    }

    @Override
    public Material get(Long id) {
        try (Session session = sessionFactory.openSession()){
            return session.get(Material.class, id);
        }
    }

    @Override
    public Material remove(Material material) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(material);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException("Can´t remove material from DB" + e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return material;
    }
}
