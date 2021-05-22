package com.issat.portail.controller;

import com.issat.portail.entity.User;
import com.issat.portail.exception.BadRequest;
import com.issat.portail.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServices userServices;

    @PostMapping("")
    public User create(@RequestBody User user){
        return userServices.create(user);
    }
    
    @GetMapping("/{id}")
    public User getById(@PathVariable String id) throws BadRequest {
        return userServices.getUserById(id);
    }
}
