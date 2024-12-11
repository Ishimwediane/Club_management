package com.club.management.services;

import com.club.management.controller.ClubDTO;
import com.club.management.entity.Club;

import java.util.List;

public interface ClubService {
    Club registerClub(ClubDTO club);
    List<Club> getAllClubs(); // Get all clubs
    Club getClubById(Integer clubId); // Get club by ID
    Club updateClub(Integer clubId, ClubDTO clubDTO); // Update club
    void deleteClub(Integer clubId); // Delete club

}