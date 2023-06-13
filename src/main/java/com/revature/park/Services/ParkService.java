package com.revature.park.Services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.park.Entities.Parks;
import com.revature.park.Repositories.ParkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ParkService {

    private final ParkRepository parkRepository;
    private final ExternalAPIService externalAPIService;


    public void saveParkDataFromAPI() throws IOException {
        String json = externalAPIService.fetchParkDataFromAPI();

        // JSON parsing and saving to the database
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);

        JsonNode dataNode = rootNode.get("data");
        if (dataNode.isArray()) {
            for (JsonNode parkNode : dataNode) {
                String fullName = parkNode.get("fullName").asText();
                String description = parkNode.get("description").asText();
                String postalCode = parkNode.get("addresses").get(0).get("postalCode").asText();
                String city = parkNode.get("addresses").get(0).get("city").asText();
                String state = parkNode.get("states").asText();

                Parks park = new Parks();
                park.setName(fullName);
                park.setDescription(description);
                park.setPostal_code(postalCode);
                park.setCity(city);
                park.setState(state);

                parkRepository.save(park);
            }
        }
    }
    public List<Parks> findAll(){
        return parkRepository.findAll();

    }
    public Optional<Parks> finById(Long id){
        return parkRepository.findById(id);

    }
}

