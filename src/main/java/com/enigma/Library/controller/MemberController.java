package com.enigma.Library.controller;

import com.enigma.Library.dto.MemberSearchDTO;
import com.enigma.Library.entity.Member;
import com.enigma.Library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("/members")
    public List<Member> getAllMember() {
        return memberService.listAllMember();
    }

    @PostMapping("/member")
    public Member newMember(@RequestBody Member member) {
        return memberService.signup(member);
    }

    @PutMapping("/member")
    public Member updateMember(@RequestBody Member member,
                               @RequestParam String id) {
        return memberService.updateProfile(member,id);
    }

    @GetMapping("/member")
    public Page<Member> searchBook(@RequestBody MemberSearchDTO memberSearchDTO,
                                   @RequestParam(name = "page", defaultValue = "0") int page,
                                   @RequestParam(name = "size", defaultValue = "3") int size,
                                   @RequestParam(name = "sortby", defaultValue = "id") String sort,
                                   @RequestParam(name = "direction", defaultValue = "asc") String direction) {
        Sort sorting = Sort.by(Sort.Direction.fromString(direction), sort);
        Pageable pageable = PageRequest.of(page, size, sorting);
        return memberService.memberPerPage(pageable,memberSearchDTO);
    }

    @DeleteMapping("/member")
    public void removeMember(@RequestParam String id) {
        memberService.removeMember(id);
    }
}
