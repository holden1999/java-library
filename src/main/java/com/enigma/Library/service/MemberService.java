package com.enigma.Library.service;

import com.enigma.Library.dto.MemberSearchDTO;
import com.enigma.Library.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberService {
    List<Member> listAllMember();
    Member signup(Member member);
    Member updateProfile(Member member, String id);
    Page<Member> memberPerPage(Pageable pageable, MemberSearchDTO memberSearchDTO);
    void removeMember(String id);
}
