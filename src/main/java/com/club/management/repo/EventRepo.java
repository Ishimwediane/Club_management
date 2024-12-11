package com.club.management.repo;

import com.club.management.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepo extends JpaRepository<Event, Long> {
    // Find events by club
    List<Event> findByClubClubId(Long clubId);

    // Find events after a certain date
    List<Event> findByEventDateAfter(LocalDateTime date);
}
