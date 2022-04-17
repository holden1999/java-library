package com.enigma.Library.service;

import com.enigma.Library.entity.Borrowing;
import org.springframework.stereotype.Service;

public interface BorrowingService {
    Borrowing updateTransaction(Borrowing borrowing, String id);

    Borrowing newBorrower(Borrowing borrowing, String idMember);
}
