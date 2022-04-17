package com.enigma.Library.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "book_id")
    private String id;
    private String author;
    private String title;
    private String edition;
    private Integer isbn;
    private Integer stock;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date registerDate = Date.valueOf(LocalDate.now());

    public Book(String id, String author, String title, String edition, Integer isbn, Integer stock, Date registerDate) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.edition = edition;
        this.isbn = isbn;
        this.stock = stock;
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", edition='" + edition + '\'' +
                ", isbn=" + isbn +
                ", stock=" + stock +
                ", registerDate=" + registerDate +
                '}';
    }
}
