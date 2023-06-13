package com.revature.park.Controller;

import com.revature.park.Entities.Events;
import com.revature.park.Entities.Parks;
import com.revature.park.Services.EventService;

import com.revature.park.Services.ParkService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;
    @PostMapping("/save")
    public ResponseEntity<String> saveEventDataFromAPI() {
        try {
            eventService.saveEventDataFromAPI();
            return ResponseEntity.ok("Event data saved successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving event data");
        }
    }
    @GetMapping("/all")
    public List<Events> findAll() {
        // return all
        return eventService.findAll();
    }
    @GetMapping("/{eventId}")
    public Optional<Events> getPark(@PathVariable Long eventId) {
        Optional <Events> event = eventService.finById(eventId);
        if (event.isEmpty()){
            throw new RuntimeException("Park Id is not found");
        }
        return event;
    }
}
