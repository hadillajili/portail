package com.issat.portail.service;

import com.issat.portail.entity.Category;
import com.issat.portail.entity.User;
import com.issat.portail.exception.BadRequest;
import com.issat.portail.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CategoryServices {

    @Autowired
    CategoryRepository categoryRepository;
    public Category create(Category category){
        category = categoryRepository.save(category);
        return category;
    }

    public Category getCategoryByName(String name) throws BadRequest {
        Optional<Category> category = categoryRepository.findCategoryByName(name);

        if (!category.isPresent())
            throw  new BadRequest("Bad category name");

        return category.get();
    }
}
