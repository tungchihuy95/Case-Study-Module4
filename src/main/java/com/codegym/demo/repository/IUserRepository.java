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
//    Page<User> findAllByNameContaining(String name, Pageable pageable);
    User findByUserName(String userName);
    User findByUserNameAndIsDeletedIsFalse(String userName);
    @Query(value="select * from users u where u.name LIKE concat('%',:name,'%') and u.isDeleted = 0",nativeQuery = true)
    Page<User> findAllByNameContaining(@Param("name") String name, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "UPDATE users u set isDeleted =1 where u.userId = :id", nativeQuery = true)
    void remove(@Param("id") Long id);
}
