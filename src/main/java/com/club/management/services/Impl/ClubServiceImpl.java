package com.club.management.services.Impl;

import com.club.management.controller.ClubDTO;
import com.club.management.entity.Club;
import com.club.management.repo.ClubRepo;
import com.club.management.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClubServiceImpl implements ClubService {

    @Autowired
    private ClubRepo clubRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Club registerClub(ClubDTO clubDTO) {
        // Ensure the password is not null or empty
        if (clubDTO.getPassword() == null || clubDTO.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password must not be null or empty");
        }

        // Create a new Club entity directly from ClubDTO
        Club club = new Club();
        club.setName(clubDTO.getName());
        club.setEmail(clubDTO.getEmail());
        club.setDescription(clubDTO.getDescription());
        club.setCreatedBy(clubDTO.getCreatedBy());
        club.setStudentId(clubDTO.getStudentId());
        club.setPassword(passwordEncoder.encode(clubDTO.getPassword()));
        club.setCreatedAt(LocalDateTime.now());

        return clubRepo.save(club);
    }

    @Override
    public List<Club> getAllClubs() {
        return clubRepo.findAll();
    }

    @Override
    public Club getClubById(Integer clubId) {
        return clubRepo.findById(clubId)
                .orElseThrow(() -> new IllegalArgumentException("Club not found with ID: " + clubId));
    }

    @Override
    @Transactional
    public Club updateClub(Integer clubId, ClubDTO clubDTO) {
        Club club = getClubById(clubId); // Fetch the existing club

        // Update the club's fields
        club.setName(clubDTO.getName());
        club.setDescription(clubDTO.getDescription());
        club.setEmail(clubDTO.getEmail());
        club.setStudentId(clubDTO.getStudentId());
        club.setCreatedBy(clubDTO.getCreatedBy());
        // Password update logic can be added if needed
        if (clubDTO.getPassword() != null && !clubDTO.getPassword().isEmpty()) {
            club.setPassword(passwordEncoder.encode(clubDTO.getPassword()));
        }

        return clubRepo.save(club); // Save the updated club
    }

    @Override
    @Transactional
    public void deleteClub(Integer clubId) {
        Club club = getClubById(clubId); // Fetch the existing club
        clubRepo.delete(club); // Delete the club
    }
}