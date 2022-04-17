package com.enigma.Library.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Borrowing {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "borrowing_id")
    private String id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateBorrowed;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateReturn;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Borrowing(String id, Date dateBorrowed, Date dateReturn, Book book, Member member) {
        this.id = id;
        this.dateBorrowed = dateBorrowed;
        this.dateReturn = dateReturn;
        this.book = book;
        this.member = member;
    }

    @Override
    public String toString() {
        return "Borrowing{" +
                "id='" + id + '\'' +
                ", dateBorrowed=" + dateBorrowed +
                ", dateReturn=" + dateReturn +
                ", book=" + book +
                ", member=" + member +
                '}';
    }
}
