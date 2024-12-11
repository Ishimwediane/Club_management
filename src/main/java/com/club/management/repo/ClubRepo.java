package com.club.management.repo;

import com.club.management.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepo extends JpaRepository<Club, Integer> {
    // Add custom queries here if needed, e.g.,
    Club findByName(String name);
}
