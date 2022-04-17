package com.enigma.Library.service;

import com.enigma.Library.dto.BookSearchDTO;
import com.enigma.Library.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    List<Book> listAllBook();
    Book addNewBook(Book book);
    Book updateBook(Book book);
    Page<Book> getBookPerPage(Pageable pageable, BookSearchDTO bookSearchDTO);
    void deletebook(String id);
}
