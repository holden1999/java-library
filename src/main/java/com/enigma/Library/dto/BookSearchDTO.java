package com.enigma.Library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor @AllArgsConstructor
public class BookSearchDTO {
    private String searchBookAuthor;
    private String searchBookTitle;
}
