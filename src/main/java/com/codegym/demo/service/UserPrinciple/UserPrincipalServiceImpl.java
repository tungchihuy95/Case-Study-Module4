package com.codegym.demo.service.UserPrinciple;

import com.codegym.demo.model.Role;
import com.codegym.demo.model.User;
import com.codegym.demo.repository.IUserPrincipalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codegym.demo.model.UserPrincipal;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserPrincipalServiceImpl implements IUserPrincipalService {
    @Autowired
    IUserPrincipalRepository userPrincipalRepository;

    @Override
    public User findByUserName(String username) {
        User user = userPrincipalRepository.findByUserName(username);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userPrincipalRepository.findByUserName(username);
        System.out.println("Account=" + user);

        if(user == null){
            throw new UsernameNotFoundException("User "+ username + " was not found in the database");
        }
        Iterable<Role> roles = user.getRoles();
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
        UserPrincipal userPrincipal = new UserPrincipal(user.getUserId(),user.getName(),user.getPassword(),grantedAuthorityList);
        return userPrincipal;
    }
}
