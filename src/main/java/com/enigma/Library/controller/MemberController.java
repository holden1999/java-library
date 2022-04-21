package com.enigma.Library.controller;

import com.enigma.Library.constant.ApiUrlConstant;
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

@RequestMapping(ApiUrlConstant.member)
@RestController
public class MemberController {
    @Autowired
    MemberService memberService;

    @PostMapping
    public Member newMember(@RequestBody Member member) {
        return memberService.signup(member);
    }

    @PutMapping
    public Member updateMember(@RequestBody Member member,
                               @RequestParam String id) {
        return memberService.updateProfile(member,id);
    }

    @GetMapping
    public Page<Member> searchBook(@RequestBody MemberSearchDTO memberSearchDTO,
                                   @RequestParam(name = "page", defaultValue = "0") int page,
                                   @RequestParam(name = "size", defaultValue = "3") int size,
                                   @RequestParam(name = "sortby", defaultValue = "id") String sort,
                                   @RequestParam(name = "direction", defaultValue = "asc") String direction) {
        Sort sorting = Sort.by(Sort.Direction.fromString(direction), sort);
        Pageable pageable = PageRequest.of(page, size, sorting);
        return memberService.memberPerPage(pageable,memberSearchDTO);
    }

    @DeleteMapping
    public void removeMember(@RequestParam String id) {
        memberService.removeMember(id);
    }
}
