package com.codegym.demo.service.Role;

import com.codegym.demo.model.Role;
import com.codegym.demo.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IRoleService  {
    Iterable<Role> findAll();

    Role save(Role t);

    Optional<Role> findById(Long id);

    void remove(Long id);
}
