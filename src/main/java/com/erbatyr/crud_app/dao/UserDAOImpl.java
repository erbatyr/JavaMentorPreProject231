package com.erbatyr.crud_app.dao;

import com.erbatyr.crud_app.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> userList() {
        List<User> users = entityManager.createQuery("select user from User user", User.class).getResultList();
        return users;
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(entityManager.find(User.class, user.getId()));
    }

    @Override
    public void editUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.detach(user);
        return user;
    }
}
