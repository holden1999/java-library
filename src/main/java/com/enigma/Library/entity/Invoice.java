package com.enigma.Library.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "invoice_id")
    private String id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date paymentDate = Date.valueOf(LocalDate.now());
    private double invoice;

    @OneToOne
    @JoinColumn(name = "borrowing_id")
    private Borrowing borrowing;

    public Invoice(String id, Date paymentDate, double invoice, Borrowing borrowing) {
        this.id = id;
        this.paymentDate = paymentDate;
        this.invoice = invoice;
        this.borrowing = borrowing;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id='" + id + '\'' +
                ", paymentDate='" + paymentDate + '\'' +
                ", invoice=" + invoice +
                ", borrowing=" + borrowing +
                '}';
    }
}
