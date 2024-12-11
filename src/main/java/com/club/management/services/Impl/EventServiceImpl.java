package com.club.management.services.Impl;

import com.club.management.controller.EventDTO;
import com.club.management.entity.Club;
import com.club.management.entity.Event;
import com.club.management.repo.ClubRepo;
import com.club.management.repo.EventRepo;
import com.club.management.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private ClubRepo clubRepo;

    @Autowired
    private EventRepo eventRepo;

    @Override
    @Transactional
    public String registerEvent(EventDTO eventDTO) {
        // Validate Club ID
        if (eventDTO.getClub() == null || eventDTO.getClub().getClubId() == null || eventDTO.getClub().getClubId() == 0) {
            return "Club ID must be provided and cannot be zero.";
        }

        Integer clubId = eventDTO.getClub().getClubId();
        Club club = clubRepo.findById(clubId)
                .orElseThrow(() -> new RuntimeException("Club not found with ID: " + clubId));

        // Validate Event Data
        if (eventDTO.getName() == null || eventDTO.getName().isEmpty()) {
            return "Event name must be provided.";
        }
//        if (eventDTO.getDate() == null) {
//            return "Event date must be provided.";
//        }

        // Create and populate the Event entity
        Event event = new Event();
        event.setClub(club); // Associate the event with the club
        event.setName(eventDTO.getName());
        event.setDescription(event.getDescription());
        event.setLocation(event.getLocation());
        event.setCreatedBy(event.getCreatedBy());
        event.setEventDate(eventDTO.getEventDate());
        event.setCreatedAt(LocalDateTime.now());

        // Save the event to the database
        eventRepo.save(event);

        return "Event registered successfully";
    }

}