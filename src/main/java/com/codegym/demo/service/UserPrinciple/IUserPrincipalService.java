package com.codegym.demo.service.UserPrinciple;

import com.codegym.demo.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserPrincipalService extends UserDetailsService {
    User findByUserName(String username);
}
