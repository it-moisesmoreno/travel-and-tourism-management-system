package com.it_moisesmoreno.TourismAndTravelMS.controllers;

import java.util.ArrayList;
import java.util.List;

// DestinationController.java

import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.it_moisesmoreno.TourismAndTravelMS.entities.Destination;
import com.it_moisesmoreno.TourismAndTravelMS.repositories.DestinationRepository;

@RestController
@RequestMapping("/destinations")
public class DestinationController {

    private DestinationRepository destinationRepository;

    public DestinationController(final DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
      }

    @GetMapping("/search")
    public List<Destination> searchDestinations(
    @RequestParam(name="maxPrice", required = false) Double price,
    @RequestParam(name="isActive", required = false) Boolean isActive
    ) {
        if (price != null && isActive != null && isActive) { 
          return this.destinationRepository.findByPriceLessThanAndIsActiveTrue(price);
        }
        if (price != null) {
          return this.destinationRepository.findByPriceLessThan(price);
        }
        if (isActive != null && isActive) {
          return this.destinationRepository.findByIsActiveTrue();
        }
        if (isActive != null && !isActive) {
          return this.destinationRepository.findByIsActiveFalse();
        }

        return new ArrayList<>();
    }

    @GetMapping
    public Iterable<Destination>  getAllDestinations() {
        return this.destinationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Destination>  getDestinationById(@PathVariable("id") Integer id) {
        return this.destinationRepository.findById(id);
    }

    @PostMapping()
    public Destination createNewDestination(@RequestBody Destination destination){
      Destination newDestination = this.destinationRepository.save(destination);
      return newDestination;
    }

    @PutMapping("/{id}")
    public Destination updateDestination (@PathVariable("id") Integer id, 
    @RequestBody Destination d){
      Optional<Destination> destinationToUpdateOptional = this.destinationRepository.findById(id);
      if(!destinationToUpdateOptional.isPresent()){
        return null;
      }
      Destination destinationToUpdate = destinationToUpdateOptional.get();
  
      if(d.getName() != null){
        destinationToUpdate.setName(d.getName());
      }
      if(d.getDescription() != null){
        destinationToUpdate.setDescription(d.getDescription());
      }
      if(d.getLocation() != null){
        destinationToUpdate.setLocation(d.getLocation());
      }
      if(d.getRating() > 0.0){
        destinationToUpdate.setRating(d.getRating());
      }
      if(d.getPrice() > 0.0){
        destinationToUpdate.setPrice(d.getPrice());
      }
      if(d.getImageUrl() != null){
        destinationToUpdate.setImageUrl(d.getImageUrl());
      }
  
      Destination updatedDestination = this.destinationRepository.save(destinationToUpdate);
      return updatedDestination;
    }

    @DeleteMapping("/{id}")
    public Destination deleteDestination(@PathVariable("id") Integer id) {
      Optional<Destination> destinationToDeleteOptional = this.destinationRepository.findById(id);
      if (!destinationToDeleteOptional.isPresent()) {
        return null;
      }
      Destination destinationToDelete = destinationToDeleteOptional.get();
      this.destinationRepository.delete(destinationToDelete);
      return destinationToDelete;
    }
}
