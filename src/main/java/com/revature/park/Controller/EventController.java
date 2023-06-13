package com.revature.park.Controller;

import com.revature.park.Services.EventService;

import com.revature.park.Services.ParkService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
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
}
