package org.sarahwdt.model.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.sarahwdt.model.entities.User;
import org.sarahwdt.model.utils.HibernateSessionFactoryUtil;

import java.util.List;


public class UserDAO implements DAO<User>{
    public User findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    public void save(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    public List<User> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<User> users = session.createQuery("FROM User").list();
        session.close();
        return users;
    }
}
