package com.revature.park.Controller;

import com.revature.park.Services.ParkService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/parks")
public class ParkController {

    private final ParkService parkService;



    @PostMapping("/save")
    public ResponseEntity<String> saveParkDataFromAPI() {
        try {
            parkService.saveParkDataFromAPI();
            return ResponseEntity.ok("Park data saved successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving park data");
        }
    }
}

