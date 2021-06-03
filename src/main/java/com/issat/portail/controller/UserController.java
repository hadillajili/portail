package com.issat.portail.controller;

import com.issat.portail.entity.User;
import com.issat.portail.exception.BadRequest;
import com.issat.portail.repository.UserRepository;
import com.issat.portail.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserServices userServices;

    @PostMapping("")
    public User create(@Valid @RequestBody User user){
        return userServices.create(user);
    }
    
    @GetMapping("/{id}")
    public User getById(@PathVariable String id) throws BadRequest {
        return userServices.getUserById(id);
    }
    @GetMapping("")
    public List<User> getAllUsers() {
        return userServices.ListAllUsers();
    }
    @PostMapping("/{userId}/category/{categoryId}")
    public User addCategory(@PathVariable String userId,@PathVariable String categoryId) throws BadRequest {
        return userServices.addCategory(userId,categoryId);
    }

    @PostMapping("/{userId}/friend/{friendId}")
    public User addFriend(@PathVariable String userId,@PathVariable String friendId) throws BadRequest {
        return userServices.addFriend(userId,friendId);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){
        userServices.deleteUser(id);
    }




}
