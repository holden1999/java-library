package com.enigma.Library.service;

import com.enigma.Library.entity.Invoice;

import java.util.List;

public interface InvoiceService {

    Invoice newBill(Invoice invoice, String id);

    List<Invoice> report();
}
