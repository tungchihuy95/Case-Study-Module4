package com.codegym.demo.repository;


import com.codegym.demo.model.Author;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepository extends PagingAndSortingRepository<Author, Long> {
}