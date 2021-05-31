package com.issat.portail.service;

import com.issat.portail.dto.UserPostDTO;
import com.issat.portail.entity.Category;
import com.issat.portail.entity.Post;
import com.issat.portail.entity.User;
import com.issat.portail.exception.BadRequest;
import com.issat.portail.repository.CategoryRepository;
import com.issat.portail.repository.PostRepository;
import com.issat.portail.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServices {

    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public Post create(UserPostDTO post) throws BadRequest {
        Optional<User> user = userRepository.findById(post.getUser());

        if (!user.isPresent())
            throw new BadRequest();

        Optional<Category> category = categoryRepository.findById(post.getCategory());

        if (!category.isPresent())
            throw new BadRequest();

        Post post1 = new Post();

        post1.setCategory(category.get());
        post1.setUser(user.get());
        post1.setDescription(post.getDescription());
        post1.setImageUrl(post.getImageUrl());
        post1 = postRepository.save(post1);
        return post1;
    }

    public List<Post> getAllPosts(String userId) throws BadRequest {
        List<Post> posts = postRepository.findAllByUserId(userId);

        if (posts.isEmpty())
            throw  new BadRequest("no posts found");

        return  posts;
    }

    public List<Post> getAllPostsByCategory(String categoryId) throws BadRequest {
        List<Post> posts = postRepository.findAllByCategoryId(categoryId);

        if (posts.isEmpty())
            throw  new BadRequest("no posts found");

        return  posts;
    }
}
