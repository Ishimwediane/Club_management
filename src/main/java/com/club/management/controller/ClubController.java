package com.club.management.controller;

import com.club.management.entity.Club;
import com.club.management.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/club")
public class ClubController {

    @Autowired
    private ClubService clubService;

    @PostMapping("/register")
    public ResponseEntity<Club> registerClub(@RequestBody ClubDTO clubDTO) {
        Club registeredClub = clubService.registerClub(clubDTO);
        return ResponseEntity.ok(registeredClub);
    }

    @GetMapping
    public ResponseEntity<List<Club>> getAllClubs() {
        List<Club> clubs = clubService.getAllClubs();
        return ResponseEntity.ok(clubs);
    }

    @GetMapping("/{clubId}")
    public ResponseEntity<Club> getClubById(@PathVariable Integer clubId) {
        Club club = clubService.getClubById(clubId);
        return ResponseEntity.ok(club);
    }

    @PutMapping("/{clubId}")
    public ResponseEntity<Club> updateClub(@PathVariable Integer clubId, @RequestBody ClubDTO clubDTO) {
        Club updatedClub = clubService.updateClub(clubId, clubDTO);
        return ResponseEntity.ok(updatedClub);
    }

    @DeleteMapping("/{clubId}")
    public ResponseEntity<Void> deleteClub(@PathVariable Integer clubId) {
        clubService.deleteClub(clubId);
        return ResponseEntity.noContent().build();
    }
}