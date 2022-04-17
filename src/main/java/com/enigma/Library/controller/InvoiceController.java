package com.enigma.Library.controller;

import com.enigma.Library.entity.Invoice;
import com.enigma.Library.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/invoices")
    public List<Invoice> report() {
        return invoiceService.report();
    }

    @PostMapping("/invoice")
    public Invoice newBill(@RequestBody Invoice invoice,
                           @RequestParam String idBorrow) {
        return invoiceService.newBill(invoice, idBorrow);
    }
}