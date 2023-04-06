package org.example.dao;

import org.example.entity.User;

import java.util.List;

public interface UserDAO {
    //create
    void add(User user);

    //read
    List<User> getAll();

    User getById(Long id);

    //update
    void update(User user);

    //delete
    void remove(Long id);
}
