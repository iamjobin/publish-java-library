package com.example.publishjavalibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.publishjavalibrary.entity.User;
import com.example.publishjavalibrary.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getUsers(){
     return userService.getUsers();
//        return null;
    }

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable("id") Long id){
        return userService.getById(id);
    }

    @PostMapping("")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
//
//    @DeleteMapping()
//    public String deleteUser(){
//        return "DELETE request";
//    }
//
    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id,
                           @RequestBody User user){
        return userService.updateUser(id,user);
    }

}
