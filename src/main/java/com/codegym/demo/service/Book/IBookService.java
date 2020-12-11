package com.codegym.demo.service.Book;

import com.codegym.demo.model.Book;
import com.codegym.demo.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService extends IGeneralService<Book> {
    Page<Book> findAllByTitleContainingAndDeletedIsFalse(String title, Pageable pageable);
}
