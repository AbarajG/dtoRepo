package com.andygomez.dto.service.impl;

import com.andygomez.dto.model.User;
import com.andygomez.dto.repository.UserRepository;
import com.andygomez.dto.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @Override
    public void saveUser(User user) {
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
