package com.codegym.demo.repository;

import com.codegym.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<User, Long> {
    Page<User> findAllByIsDeletedFalse(Pageable pageable);
    Page<User> findAllByNameContainingAndDeletedIsFalse(String name, Pageable pageable);
    Page<User> findAllByNameContaining(String name, Pageable pageable);

}
