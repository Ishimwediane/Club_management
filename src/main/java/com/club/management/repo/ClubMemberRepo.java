package com.club.management.repo;

import com.club.management.entity.ClubMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubMemberRepo extends JpaRepository<ClubMember, Integer> {
    // Find members by club
    List<ClubMember> findByClubClubId(int clubId);


}
