package com.erbatyr.crud_app.dao;

import com.erbatyr.crud_app.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> userList() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").list();
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void deleteUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }

    @Override
    public void editUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }
}
