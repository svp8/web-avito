package com.example.webAvito.controllers;

import java.util.List;
import java.util.Optional;

import com.example.webAvito.models.User;
import com.example.webAvito.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/user")
public class UserController  {
    
    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable(name = "id") Integer id){
        return userService.getById(id);
    }
    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        try {
            return userService.registerUser(user);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exist" );
        }
        
    }
    @PostMapping("/update")
    public User updateUser(@RequestBody User user){
        try {
            return userService.updateUser(user);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exist" );
        }
        
    }
    @PostMapping("/login")
    public User loginUser(@RequestBody User user){
        try {
            return userService.checkLogin(user);
        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Login error" );
        }
        
    }
}
