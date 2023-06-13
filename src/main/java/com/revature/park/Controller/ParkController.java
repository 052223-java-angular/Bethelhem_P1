package com.revature.park.Controller;

import com.revature.park.Entities.Parks;
import com.revature.park.Services.ParkService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
    @GetMapping("/all")
    public List<Parks>findAll() {
        // return all
        return parkService.findAll();
    }
    @GetMapping("/{parkId}")
    public Optional<Parks> getPark(@PathVariable Long parkId) {
        Optional <Parks> park = parkService.finById(parkId);
        if (park.isEmpty()){
            throw new RuntimeException("Park Id is not found");
        }
        return park;
    }
}

