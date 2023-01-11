package com.andygomez.dto.service;

import com.andygomez.dto.model.User;

import java.util.List;

public interface Userservice {

    User getUserById(Long id);
    List<User> getAllUsers();
    void saveNewUser(User user);
    void updateUser(Long id, User user);
    void deleteUserById(Long id);

}
