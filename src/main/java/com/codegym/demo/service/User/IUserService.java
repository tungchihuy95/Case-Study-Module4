package com.codegym.demo.service.User;

import com.codegym.demo.model.User;
import com.codegym.demo.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IUserService extends IGeneralService<User>{
    Page<User> findAllByNameContainingAndDeletedIsFalse(String name, Pageable pageable);
    Page<User> findAllByIsDeletedFalse(Pageable pageable);
    Page<User> findAllByNameContaining(String name, Pageable pageable);
}
