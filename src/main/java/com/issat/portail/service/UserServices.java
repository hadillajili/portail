package com.issat.portail.service;

import com.issat.portail.entity.Category;
import com.issat.portail.entity.User;
import com.issat.portail.exception.BadRequest;
import com.issat.portail.repository.CategoryRepository;
import com.issat.portail.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public User create(User user){
        user.setCategories(new ArrayList<>());
        user.setFriends(new ArrayList<>());
        user = userRepository.save(user);
        return user;
    }

    public List<User>  ListAllUsers() {
        return   userRepository.findAll();
    }

    public User getUserById(String id) throws BadRequest {
       Optional<User> user = userRepository.findById(id);

       if (!user.isPresent())
           throw  new BadRequest("Bad user id");

       return user.get();
    }

    public User addCategory(String userId, String categoryId) throws BadRequest {
        User user = getUserById(userId);

        Optional<Category> category = categoryRepository.findById(categoryId);

        if (!category.isPresent())
            throw new BadRequest("Category not found");

        user.addCategory(category.get());

        userRepository.save(user);

        return user;
    }

    public User addFriend(String userId, String friendId) throws BadRequest {
        User user = getUserById(userId);

        Optional<User> friend = userRepository.findById(friendId);

        if (!friend.isPresent())
            throw new BadRequest("Friend not found");

        user.addFriend(friend.get());

        userRepository.save(user);

        return user;
    }
}
