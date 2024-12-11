package com.club.management.controller;

import com.club.management.entity.ClubMember;
import com.club.management.services.ClubMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
public class ClubMemberController {

    @Autowired
    private ClubMemberService clubMemberService;

    @PostMapping("/register")
    public ResponseEntity<String> registerMember(@RequestBody ClubMemberDTO memberDTO) {
        String responseMessage = clubMemberService.registerMember(memberDTO);
        return ResponseEntity.ok(responseMessage);
    }

}