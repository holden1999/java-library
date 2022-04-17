package com.enigma.Library.service.impl;

import com.enigma.Library.entity.Borrowing;
import com.enigma.Library.entity.Invoice;
import com.enigma.Library.repository.BorrowingRepository;
import com.enigma.Library.repository.InvoiceRepository;
import com.enigma.Library.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    BorrowingRepository borrowingRepository;

    @Override
    public Invoice newBill(Invoice invoice, String idBorrow) {
        Borrowing borrowing = borrowingRepository.findById(idBorrow).get();
        invoice.setBorrowing(borrowing);
        Date startDate = invoice.getBorrowing().getDateBorrowed();
        Date finishDate = invoice.getBorrowing().getDateReturn();
//        Period period = Period.between(startDate, finishDate);
        invoice.getBorrowing().getDateReturn();
        if (startDate == finishDate) {
            invoice.setInvoice(10000);
        } else {
            invoice.setInvoice(20000);
        }
        return invoiceRepository.save(invoice);
    }

    @Override
    public List<Invoice> report() {
        return invoiceRepository.findAll();
    }
}
