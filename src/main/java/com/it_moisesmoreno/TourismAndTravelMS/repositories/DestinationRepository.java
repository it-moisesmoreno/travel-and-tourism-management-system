package com.it_moisesmoreno.TourismAndTravelMS.repositories;

import org.springframework.data.repository.CrudRepository;

import com.it_moisesmoreno.TourismAndTravelMS.entities.Destination;

public interface DestinationRepository extends CrudRepository<Destination, Long> {
    // Add custom query methods if needed
}
