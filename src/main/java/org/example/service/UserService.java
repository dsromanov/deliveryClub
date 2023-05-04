package org.example.service;

import org.example.daoImplement.UserDaoImpl;
import org.example.entity.User;

public class UserService {
    private final UserDaoImpl userDaoImpl;
    public UserService(UserDaoImpl userDaoImpl){
        this.userDaoImpl = userDaoImpl;
    }
    public Long createUser(User user){
        user.setPassword(String.valueOf(user.getPassword().hashCode()));
        userDaoImpl.add(user);
        return user.getId();
    }
    public User loginUser(String email, String password){
        User user= userDaoImpl.getByEmail(email);
        if(passwordToHash(password).equals(user.getPassword())){
            return user;
        }
        return null;
    }
    private String passwordToHash(String password){
        return String.valueOf(password.hashCode());
    }

}