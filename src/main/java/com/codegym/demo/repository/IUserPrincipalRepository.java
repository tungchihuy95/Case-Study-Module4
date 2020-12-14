package com.codegym.demo.repository;

import com.codegym.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserPrincipalRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);
    User findOneByUserId(Long id);
}
