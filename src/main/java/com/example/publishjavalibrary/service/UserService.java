package com.example.publishjavalibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.publishjavalibrary.entity.User;
import com.example.publishjavalibrary.repo.UserRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    //read
    public List<User> getUsers(){
//        Pageable thePageable = pageable.withPage(0);
//        if(pageable.getPageNumber() > 0) {
//            thePageable = pageable.withPage(pageable.getPageNumber() - 1);
//        }

        List<User> userList = new ArrayList<>();
        userRepo.getAllUser(userList).forEach(user -> userList.add(user));
        return userList;
    }

    //create
    public User createUser(User user){
        return userRepo.save(user);
    }

    public Optional<User> getById(Long id) {
        return userRepo.findById(id);
    }

    public User updateUser(Long id, User user) {
        User user1 = userRepo.findById(id).get();
        user1.setEmail(user.getEmail());
        user1.setName(user.getName());
        return userRepo.save(user1);
    }
}
