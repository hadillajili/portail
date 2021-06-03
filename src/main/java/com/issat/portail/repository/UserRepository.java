package com.issat.portail.repository;

import com.issat.portail.entity.Post;
import com.issat.portail.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {

    Optional<User> findUserByNameAndStatus(String name, String status);

}
