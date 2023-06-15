package com.example.pp312.service;

import com.example.pp312.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user); //create

    User getById(Long id); //read

    List<User> selectAllUsersFromDatabase(); //read

    void updateUser(User user); //update

    void deleteById(Long id); //delete


}
