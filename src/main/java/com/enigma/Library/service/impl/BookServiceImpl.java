package com.enigma.Library.service.impl;

import com.enigma.Library.dto.BookSearchDTO;
import com.enigma.Library.entity.Book;
import com.enigma.Library.repository.BookRepository;
import com.enigma.Library.service.BookService;
import com.enigma.Library.specification.BookSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> listAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book addNewBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Page<Book> getBookPerPage(Pageable pageable, BookSearchDTO bookSearchDTO) {
        Specification<Book> bookPredicate = BookSpecification.getSpecification(bookSearchDTO);
        return bookRepository.findAll(bookPredicate, pageable);
    }

    @Override
    public void deletebook(String id) {
        bookRepository.deleteById(id);
    }
}
