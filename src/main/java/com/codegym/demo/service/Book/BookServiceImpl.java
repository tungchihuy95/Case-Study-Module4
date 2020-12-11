package com.codegym.demo.service.Book;

import com.codegym.demo.model.Book;
import com.codegym.demo.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAllByIsDeletedFalse(pageable);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        bookRepository.remove(id);
    }

    @Override
    public Page<Book> findAllByTitleContainingAndDeletedIsFalse(String title, Pageable pageable) {
        return bookRepository.findAllByTitleContainingAndDeletedIsFalse(title, pageable);
    }
}
