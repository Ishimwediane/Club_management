package com.club.management.services.Impl;

import com.club.management.controller.ClubMemberDTO;
import com.club.management.entity.Club;
import com.club.management.entity.ClubMember;
import com.club.management.repo.ClubRepo;
import com.club.management.repo.ClubMemberRepo;
import com.club.management.services.ClubMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClubMemberServiceImpl implements ClubMemberService {

    @Autowired
    private ClubRepo clubRepo;

    @Autowired
    private ClubMemberRepo clubMemberRepo;

    @Autowired
    private PasswordEncoder passwordEncoder; // Inject PasswordEncoder

    @Override
    @Transactional
    public String registerMember(ClubMemberDTO memberDTO) {
        if (memberDTO.getClubId() == null || memberDTO.getClubId() == 0) {
            return "Club ID must be provided and cannot be zero.";
        }

        Club club = clubRepo.findById(memberDTO.getClubId())
                .orElseThrow(() -> new RuntimeException("Club not found with ID: " + memberDTO.getClubId()));

        ClubMember member = new ClubMember();
        member.setClub(club);
        member.setName(memberDTO.getName());
        member.setStudentId(memberDTO.getStudentId());
member.setRole(memberDTO.getRole());
member.setEmail(memberDTO.getEmail());
        member.setPassword(passwordEncoder.encode(memberDTO.getPassword())); // Use the injected passwordEncoder
        member.setJoinedAt(LocalDateTime.now());

        clubMemberRepo.save(member);

        return "Member registered successfully";
    }

    @Override
    public List<ClubMember> getAllMembers() {
        return clubMemberRepo.findAll();
    }

    @Override
    public ClubMember getMemberById(Integer memberId) {
        return clubMemberRepo.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found with ID: " + memberId));
    }

    @Override
    @Transactional
    public ClubMember updateMember(Integer memberId, ClubMemberDTO memberDTO) {
        ClubMember member = getMemberById(memberId);
        member.setName(memberDTO.getName());
        member.setEmail(memberDTO.getEmail());

        // Update club association if needed
        if (memberDTO.getClubId() != null) {
            Club club = clubRepo.findById(memberDTO.getClubId())
                    .orElseThrow(() -> new IllegalArgumentException("Club not found with ID: " + memberDTO.getClubId()));
            member.setClub(club);
        }

        return clubMemberRepo.save(member);
    }

    @Override
    @Transactional
    public void deleteMember(Integer memberId) {
        ClubMember member = getMemberById(memberId);
        clubMemberRepo.delete(member);
    }
}