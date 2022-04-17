package com.enigma.Library.service.impl;

import com.enigma.Library.dto.MemberSearchDTO;
import com.enigma.Library.entity.Member;
import com.enigma.Library.repository.MemberRepository;
import com.enigma.Library.service.MemberService;
import com.enigma.Library.specification.MemberSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberRepository memberRepository;

    @Override
    public List<Member> listAllMember() {
        return memberRepository.findAll();
    }

    @Override
    public Member signup(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member updateProfile(Member member, String id) {
        member.setId(id);
        return memberRepository.save(member);
    }

    @Override
    public Page<Member> memberPerPage(Pageable pageable, MemberSearchDTO memberSearchDTO) {
        Specification<Member> memberPredicate = MemberSpecification.getSpecification(memberSearchDTO);
        return memberRepository.findAll(memberPredicate, pageable);
    }

    @Override
    public void removeMember(String id) {
        memberRepository.deleteById(id);
    }
}
