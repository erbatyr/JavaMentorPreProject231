package com.erbatyr.crud_app.service;

import com.erbatyr.crud_app.dao.UserDAO;
import com.erbatyr.crud_app.dao.UserDAOImpl;
import com.erbatyr.crud_app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public List<User> userList() {
        return userDAO.userList();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    @Override
    @Transactional
    public void editUser(User user) {
        userDAO.editUser(user);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }
}
