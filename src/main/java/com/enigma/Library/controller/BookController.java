package com.enigma.Library.controller;

import com.enigma.Library.dto.BookSearchDTO;
import com.enigma.Library.entity.Book;
import com.enigma.Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public List<Book> listAllBook() {
        return bookService.listAllBook();
    }

    @PostMapping("/book")
    public Book addNewBook(@RequestBody Book book) {
        return bookService.addNewBook(book);
    }

    @PutMapping("/book")
    public Book updateBook(@RequestBody Book book,
                           @RequestParam(name = "id") String id) {
        book.setId(id);
        return bookService.updateBook(book);
    }

    @GetMapping("/book")
    public Page<Book> searchBook(@RequestBody BookSearchDTO bookSearchDTO,
                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "size", defaultValue = "3") int size,
                                 @RequestParam(name = "sortby", defaultValue = "title") String sort,
                                 @RequestParam(name = "direction", defaultValue = "asc") String direction) {
        Sort sorting = Sort.by(Sort.Direction.fromString(direction),sort);
        Pageable pageable = PageRequest.of(page, size, sorting);
        return bookService.getBookPerPage(pageable, bookSearchDTO);
    }

    @DeleteMapping("/book")
    public void deleteBook(@RequestParam String id) {
        bookService.deletebook(id);
    }
}