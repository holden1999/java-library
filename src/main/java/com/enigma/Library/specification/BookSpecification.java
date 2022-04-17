package com.enigma.Library.specification;

import com.enigma.Library.dto.BookSearchDTO;
import com.enigma.Library.entity.Book;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BookSpecification {
    public static Specification<Book> getSpecification(BookSearchDTO bookSearchDTO) {
        return new Specification<Book>() {
            List<Predicate> predicates = new ArrayList<>();
            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (bookSearchDTO.getSearchBookAuthor() != null) {
                    Predicate bookAuthorPredicate = criteriaBuilder.like(root.get("author"), "%" + bookSearchDTO.getSearchBookAuthor() + "%");
                    predicates.add(bookAuthorPredicate);
                }

                if (bookSearchDTO.getSearchBookTitle() != null) {
                    Predicate bookTitlePredicate = criteriaBuilder.like(root.get("title"), "%" + bookSearchDTO.getSearchBookTitle() + "%");
                    predicates.add(bookTitlePredicate);
                }
                Predicate[] arrayPredicate = predicates.toArray(new Predicate[predicates.size()]);
                return criteriaBuilder.and(arrayPredicate);
            }
        };
    }
}
