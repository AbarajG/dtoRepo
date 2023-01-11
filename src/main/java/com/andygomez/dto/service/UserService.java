package com.andygomez.dto.service;

import com.andygomez.dto.model.User;

import java.util.List;

public interface UserService {

    User findUserById(Long id);
    List<User> findAllUsers();
    void saveUser(User user);
    void updateUser(Long id, User user);
    void deleteUserById(Long id);

}
