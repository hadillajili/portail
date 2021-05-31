package com.issat.portail.repository;

import com.issat.portail.entity.Category;
import com.issat.portail.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CategoryRepository extends MongoRepository<Category, String> {
    Optional<Category> findCategoryByName(String name);
}
