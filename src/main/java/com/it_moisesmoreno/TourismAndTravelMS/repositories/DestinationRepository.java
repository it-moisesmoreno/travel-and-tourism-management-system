package com.it_moisesmoreno.TourismAndTravelMS.repositories;

import java.util.List; 

import org.springframework.data.repository.CrudRepository;

import com.it_moisesmoreno.TourismAndTravelMS.entities.Destination;

public interface DestinationRepository extends CrudRepository<Destination, Integer> {
    List<Destination> findByIsActiveTrue();
    List<Destination> findByIsActiveFalse();
    List<Destination> findByPriceLessThan(Integer price);
    List<Destination> findByIsActiveTrueAndPriceLessThan(Integer price);
    List<Destination> findByIsActiveFalseAndPriceLessThan(Integer price);
}
