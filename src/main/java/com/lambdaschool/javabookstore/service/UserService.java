package com.lambdaschool.javabookstore.service;

import com.lambdaschool.javabookstore.model.User;

import java.util.List;

public interface UserService {

    User save(User user);
    List<User> findAll();
    void delete(long id);
}