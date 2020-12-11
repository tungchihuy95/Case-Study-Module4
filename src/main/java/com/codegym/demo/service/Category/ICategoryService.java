package com.codegym.demo.service.Category;

import com.codegym.demo.model.Category;

import java.util.Optional;

public interface ICategoryService{
    Iterable<Category> findAll();

    Category save(Category category);

    Optional<Category> findById(Long id);

    void remove(Long id);
}
