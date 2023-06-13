package com.revature.park.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class ExternalAPIService {
    @Autowired
    //RestTemplate restTemplate = new RestTemplate();
    private final RestTemplate restTemplate;
    private final String apiKey;
    public ExternalAPIService(RestTemplate restTemplate, @Value("${api.key}") String apiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }

    public String fetchParkDataFromAPI() {
        String url = "https://developer.nps.gov/api/v1/parks?limit=469&&api_key=" + apiKey;

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to fetch park data from the API");
        }
    }
    public String fetchEventDataFromAPI() {
        String url = "https://developer.nps.gov/api/v1/events?pageNumber=20&api_key=" + apiKey;

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to fetch event data from the API");
        }
    }
}

