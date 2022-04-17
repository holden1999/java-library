package com.enigma.Library.service.impl;

import com.enigma.Library.entity.Book;
import com.enigma.Library.entity.Borrowing;
import com.enigma.Library.entity.Member;
import com.enigma.Library.repository.BookRepository;
import com.enigma.Library.repository.BorrowingRepository;
import com.enigma.Library.repository.MemberRepository;
import com.enigma.Library.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class BorrowingServiceImpl implements BorrowingService {
    @Autowired
    BorrowingRepository borrowingRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    MemberRepository memberRepository;

    @Override
    public Borrowing newBorrower(Borrowing borrowing, String idMember) {
        Book book = bookRepository.findById(borrowing.getBook().getId()).get();
        Member member = memberRepository.findById(idMember).get();
        book.setStock(book.getStock() - 1);
        borrowing.setBook(book);
        borrowing.setMember(member);
        borrowing.setDateBorrowed(Date.valueOf(LocalDate.now()));
        return borrowingRepository.save(borrowing);
    }

    @Override
    public Borrowing updateTransaction(Borrowing borrowing, String id) {
        borrowing = borrowingRepository.findById(id).get();
        Book book = bookRepository.findById(borrowing.getBook().getId()).get();
        Member member = memberRepository.findById(borrowing.getMember().getId()).get();
        borrowing.setId(id);
        borrowing.setBook(book);
        borrowing.setMember(member);
        borrowing.setDateBorrowed(borrowing.getDateBorrowed());
        borrowing.setDateReturn(Date.valueOf(LocalDate.now()));
        book.setStock(+1);
        return borrowingRepository.save(borrowing);
    }
}
