package com.revature.park.Services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.park.Entities.Events;

import com.revature.park.Entities.Parks;
import com.revature.park.Repositories.EventRepository;
import com.revature.park.Repositories.ParkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;
@Service
@AllArgsConstructor
public class EventService {
    private final Parks park;
    private final ParkRepository parkRepository;
    private final EventRepository eventRepository;
    private final ExternalAPIService externalAPIService;


    public void saveEventDataFromAPI() throws IOException {
        String json = externalAPIService.fetchEventDataFromAPI();

        // JSON parsing and saving to the database
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);

        JsonNode dataNode = rootNode.get("data");
        if (dataNode.isArray()) {
            for (JsonNode parkNode : dataNode) {
                String fullName = parkNode.get("title").asText();
                String description = parkNode.get("description").asText();
                String parkfullname=parkNode.get("parkfullname").asText();

                // Retrieve the Park entity based on the fullName
                Parks park = parkRepository.findByName(parkfullname);

                if (park != null) {
                    Events event = new Events();
                    event.setName(fullName);
                    event.setDescription(description);
                    event.setParks(park); // Set the ID of the Park entity

                    eventRepository.save(event);
                } else {
                    // Handle the case when the Park entity is not found
                    System.out.println("Park not found for fullName: " + fullName);
                }
            }
        }
}

}
