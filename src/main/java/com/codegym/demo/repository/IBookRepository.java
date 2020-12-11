package com.codegym.demo.repository;

import com.codegym.demo.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IBookRepository extends PagingAndSortingRepository<Book,Long> {
    Page<Book> findAllByIsDeletedFalse(Pageable pageable);
    Page<Book> findAllByTitleContainingAndDeletedIsFalse(String title, Pageable pageable);
    @Transactional
    @Modifying
    @Query(value = "UPDATE books b set isDeleted = 1 where b.bookId = :id", nativeQuery = true)
    void remove(@Param("id") Long id);
}
