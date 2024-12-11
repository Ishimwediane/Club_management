package com.club.management.repo;

import com.club.management.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Long> {
    // Add custom queries here if needed, e.g.,
//    Users findByEmail(String email);
}
