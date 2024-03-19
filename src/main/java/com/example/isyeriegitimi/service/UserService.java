package com.example.isyeriegitimi.service;


import com.example.isyeriegitimi.model.User;

import java.util.List;
import java.util.Optional;
public interface UserService {
    List<User> findAllUser();
    Optional<User> findById(int id);
    User saveUser(User users);
    User updateUser(User users);
    void deleteUser(int id);
}

