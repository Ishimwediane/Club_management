package com.club.management.controller;

import com.club.management.entity.Event;
import com.club.management.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/register")
    public ResponseEntity<String> registerEvent(@RequestBody EventDTO eventDTO) {
        String responseMessage = eventService.registerEvent(eventDTO);
        return ResponseEntity.ok(responseMessage);
    }
}