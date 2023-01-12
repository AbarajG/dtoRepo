package com.andygomez.dto.service.impl;

import com.andygomez.dto.dto.UserDto;
import com.andygomez.dto.exceptions.NotFoundException;
import com.andygomez.dto.mapper.UserMapper;
import com.andygomez.dto.model.User;
import com.andygomez.dto.repository.UserRepository;
import com.andygomez.dto.service.UserService;
import com.andygomez.dto.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private MessageUtil messageUtil;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto findUserById(Long id) {
        return userMapper.toDto(repository.findById(id).orElseThrow(
                () -> new NotFoundException(messageUtil
                        .getMessage("notFound",null, Locale.getDefault()))
        ));
    }

    @Override
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public void saveUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        repository.save(user);
    }

    @Transactional
    @Override
    public void updateUser(Long id, UserDto userDto) {
        User newUser = repository.findById(id).orElseThrow(
                () -> new NotFoundException(messageUtil
                        .getMessage("notFound", null, Locale.getDefault()))
        );
        userMapper.updateEntity(userDto, newUser);
        repository.save(newUser);
    }

    @Override
    public void deleteUserById(Long id) {
        User user1 = repository.findById(id).orElseThrow(
                ()-> new NotFoundException(messageUtil
                        .getMessage("notFound", null, Locale.getDefault()))
        );
        repository.deleteById(id);
    }
}
