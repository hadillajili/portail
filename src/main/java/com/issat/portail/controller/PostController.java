package com.issat.portail.controller;

import com.issat.portail.dto.UserPostDTO;
import com.issat.portail.entity.Post;
import com.issat.portail.entity.User;
import com.issat.portail.exception.BadRequest;
import com.issat.portail.service.PostServices;
import com.issat.portail.service.UserServices;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
}
