package com.enigma.Library.controller;

import com.enigma.Library.constant.ApiUrlConstant;
import com.enigma.Library.entity.Invoice;
import com.enigma.Library.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ApiUrlConstant.invoice)
@RestController
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;

    @GetMapping("s")
    public List<Invoice> report() {
        return invoiceService.report();
    }

    @PostMapping
    public Invoice newBill(@RequestBody Invoice invoice,
                           @RequestParam String idBorrow) {
        return invoiceService.newBill(invoice, idBorrow);
    }
}