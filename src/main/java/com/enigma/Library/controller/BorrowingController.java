package com.enigma.Library.controller;

import com.enigma.Library.constant.ApiUrlConstant;
import com.enigma.Library.entity.Borrowing;
import com.enigma.Library.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiUrlConstant.borrowing)
@RestController
public class BorrowingController {
    @Autowired
    BorrowingService borrowingService;

    @PostMapping
    public Borrowing newBorrower(@RequestBody Borrowing borrowing,
                                 @RequestParam String idMember) {
        return borrowingService.newBorrower(borrowing, idMember);
    }

    @PutMapping
    public Borrowing updateTransaction(@RequestBody Borrowing borrowing,
                                       @RequestParam String id) {
        return borrowingService.updateTransaction(borrowing, id);
    }
}
