package com.erbatyr.crud_app.service;

import com.erbatyr.crud_app.model.User;

import java.util.List;

public interface UserService {

    List<User> userList();
    void addUser(User user);
    void deleteUser(User user);
    void editUser(User user);
    User getUserById(int id);

}
