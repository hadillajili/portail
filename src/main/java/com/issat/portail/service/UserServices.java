package com.issat.portail.service;

import com.issat.portail.entity.User;
import com.issat.portail.exception.BadRequest;
import com.issat.portail.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;


    public User create(User user){
        user = userRepository.save(user);
        return user;
    }

    public User getUserById(String id) throws BadRequest {
       Optional<User> user = userRepository.findById(id);

       if (!user.isPresent())
           throw  new BadRequest("Bad user id");

       return user.get();
    }
}
