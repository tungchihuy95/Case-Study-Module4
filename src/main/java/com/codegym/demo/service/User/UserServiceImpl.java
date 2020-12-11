package com.codegym.demo.service.User;

import com.codegym.demo.model.User;
import com.codegym.demo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserRepository userRepository;
    @Override
    public Page<User> findAllByNameContainingAndDeletedIsFalse(String name, Pageable pageable) {
        return userRepository.findAllByNameContainingAndDeletedIsFalse(name, pageable);
    }

    @Override
    public Page<User> findAllByIsDeletedFalse(Pageable pageable) {
        return userRepository.findAllByIsDeletedFalse(pageable);
    }

    @Override
    public Page<User> findAllByNameContaining(String name, Pageable pageable) {
        return userRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAllByIsDeletedFalse(pageable);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        if(userRepository.findById(id).isPresent()){
            User user = userRepository.findById(id).get();
            user.setDeleted(true);
            userRepository.save(user);
        }

    }
}
