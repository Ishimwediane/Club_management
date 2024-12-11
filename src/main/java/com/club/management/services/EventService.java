package com.club.management.services;

import com.club.management.controller.EventDTO;
import com.club.management.entity.Event;

public interface EventService {
    String registerEvent(EventDTO eventDTO);

}