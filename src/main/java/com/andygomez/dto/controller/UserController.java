package com.andygomez.dto.controller;

import com.andygomez.dto.model.User;
import com.andygomez.dto.service.Userservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    Userservice service;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return new ResponseEntity<>(service.getUserById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(User user){
        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> saveNewUser(@RequestBody User user){
        service.saveNewUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        service.updateUser(id, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable Long id){
        service.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
