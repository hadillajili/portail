package com.issat.portail.controller;

import com.issat.portail.entity.Category;
import com.issat.portail.entity.User;
import com.issat.portail.service.CategoryServices;
import com.issat.portail.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    CategoryServices categoryServices;

    @PostMapping("")
    public Category create(@Valid @RequestBody Category category){
        return categoryServices.create(category);
    }
}
