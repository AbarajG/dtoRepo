package com.andygomez.dto.service;

import com.andygomez.dto.dto.UserDto;
import com.andygomez.dto.model.User;

import java.util.List;

public interface UserService {

    UserDto findUserById(Long id);
    List<User> findAllUsers();
    void saveUser(UserDto userDto);
    void updateUser(Long id, UserDto userDto);
    void deleteUserById(Long id);

}
