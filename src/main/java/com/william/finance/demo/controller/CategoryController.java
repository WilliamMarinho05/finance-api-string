package com.william.finance.demo.controller;

import com.william.finance.demo.model.Category;
import com.william.finance.demo.repository.CategoryRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/categories")
@RequiredArgsConstructor

public class CategoryController {

    private final CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> listAll(){
        return categoryRepository.findAll();
    }

    @PostMapping
    public Category create(@Valid @RequestBody Category category) {
        return categoryRepository.save(category);
    }
}
