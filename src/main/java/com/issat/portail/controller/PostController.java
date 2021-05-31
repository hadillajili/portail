package com.issat.portail.controller;

import com.issat.portail.dto.UserPostDTO;
import com.issat.portail.entity.Post;
import com.issat.portail.exception.BadRequest;
import com.issat.portail.service.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post")
@CrossOrigin("*")
public class PostController {
    @Autowired
    PostServices postServices;


    @PostMapping("")
    public Post create(@Valid @RequestBody UserPostDTO post) throws BadRequest {
        return postServices.create(post);
    }
    @GetMapping("/{id}")
    public List<Post> getAllById(@PathVariable String id) throws BadRequest {
        return postServices.getAllPosts(id);
    }

    @GetMapping("/{categoryId}")
    public List<Post> getAllByCategoryId(@PathVariable String categoryId) throws BadRequest {
        return postServices.getAllPostsByCategory(categoryId);
    }
}
