package com.it_moisesmoreno.TourismAndTravelMS.controllers;

// DestinationController.java

import org.springframework.web.bind.annotation.*;

import com.it_moisesmoreno.TourismAndTravelMS.entities.Destination;
import com.it_moisesmoreno.TourismAndTravelMS.repositories.DestinationRepository;

@RestController
public class DestinationController {

    private DestinationRepository destinationRepository;

    public DestinationController(final DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
      }

    @GetMapping("/destinations")
    public Iterable<Destination>  getAllDestinations() {
        return this.destinationRepository.findAll();
    }

    // Add more endpoints as needed for updating, deleting, or querying destinations
}
