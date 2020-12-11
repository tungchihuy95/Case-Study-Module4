package com.codegym.demo.repository;

import com.codegym.demo.model.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IRoleRepository extends PagingAndSortingRepository<Role,Long> {

}
