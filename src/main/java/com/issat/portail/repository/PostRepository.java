package com.issat.portail.repository;

import com.issat.portail.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post,String> {
    List<Post> findAllByDescriptionRegex(String  name);
}
