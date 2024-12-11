package com.club.management.services;

import com.club.management.controller.ClubMemberDTO;
import com.club.management.entity.ClubMember;

import java.util.List;

public interface ClubMemberService {
    String registerMember(ClubMemberDTO memberDTO);
    List<ClubMember> getAllMembers();
    ClubMember getMemberById(Integer memberId);
    ClubMember updateMember(Integer memberId, ClubMemberDTO memberDTO);
    void deleteMember(Integer memberId);
}