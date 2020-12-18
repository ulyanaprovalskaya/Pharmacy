package com.grsu.pharmacy.dataAccess.genericDao;

import com.grsu.pharmacy.dataAccess.sessionFactory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

    public abstract Class<T> getType();

    public T findById(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        T t = session.get(getType(), id);
        return t;
    }

    public void save(T entity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(entity);
        tx1.commit();
        session.close();
    }

    public void update(T entity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(entity);
        tx1.commit();
        session.close();
    }

    public void delete(T entity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(entity);
        tx1.commit();
        session.close();
    }
}
