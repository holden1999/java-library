package com.enigma.Library.specification;

import com.enigma.Library.dto.MemberSearchDTO;
import com.enigma.Library.entity.Member;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class MemberSpecification {
    public static Specification<Member> getSpecification(MemberSearchDTO memberSearchDTO) {
        return new Specification<Member>() {
            List<Predicate> predicates = new ArrayList<>();
            @Override
            public Predicate toPredicate(Root<Member> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (memberSearchDTO.getSearchMemberFullname() != null) {
                    Predicate memberFullNamePredicate = criteriaBuilder.like(root.get("fullName"), "%" + memberSearchDTO.getSearchMemberFullname() + "%");
                    predicates.add(memberFullNamePredicate);
                }
                if (memberSearchDTO.getSearchMemberUsername() != null) {
                    Predicate memberUserNamePredicate = criteriaBuilder.like(root.get("username"), "%" + memberSearchDTO.getSearchMemberUsername() + "%");
                    predicates.add(memberUserNamePredicate);
                }
                Predicate[] arrayPredicate = predicates.toArray(new Predicate[predicates.size()]);
                return criteriaBuilder.and(arrayPredicate);
            }
        };
    }
}
