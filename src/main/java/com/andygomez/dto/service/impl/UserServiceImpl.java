package com.andygomez.dto.service.impl;

import com.andygomez.dto.model.User;
import com.andygomez.dto.repository.UserRepository;
import com.andygomez.dto.service.Userservice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements Userservice {

    private UserRepository repository;

    @Override
    public User getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public void saveNewUser(User user) {
        repository.save(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        User newUser = repository.findById(id).orElseThrow(
                () -> new NoSuchElementException("User does not exist")
        );
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        repository.save(newUser);
    }

    @Override
    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }
}
