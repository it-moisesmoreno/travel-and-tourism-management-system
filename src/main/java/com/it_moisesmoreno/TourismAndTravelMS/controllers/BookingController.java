package com.it_moisesmoreno.TourismAndTravelMS.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

// BookingController.java

import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.it_moisesmoreno.TourismAndTravelMS.entities.Booking;
import com.it_moisesmoreno.TourismAndTravelMS.repositories.BookingRepository;


@RestController
@RequestMapping("/bookings")
public class BookingController {

    private BookingRepository bookingRepository;

    public BookingController(final BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
      }

    @GetMapping("/search")
    public List<Booking> searchBookings(
    @RequestParam(name="userId", required = false) Integer userId,
    @RequestParam(name="destinationId", required = false) Integer destinationId,
    @RequestParam(name="bookingDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date bookingDate,
    @RequestParam(name="beforeDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date beforeDate,
    @RequestParam(name="startDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
    @RequestParam(name="endDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate
    ) {
        if (userId != null & destinationId != null) {
          return this.bookingRepository.findByUserIdAndDestinationId(userId, destinationId);
        }
        if (startDate != null & endDate != null) {
          return this.bookingRepository.findByBookingDateBetween(startDate, endDate);
        }
        if (bookingDate != null) {
          return this.bookingRepository.findAllWithBookingDate(bookingDate);
        }
        if (beforeDate != null) {
          return this.bookingRepository.findByBookingDateLessThan(beforeDate);
        }

        return new ArrayList<>();
    }

    @GetMapping
    public Iterable<Booking>  getAllBookings() {
        return this.bookingRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Booking>  getBookingById(@PathVariable("id") Integer id) {
        return this.bookingRepository.findById(id);
    }

    @PostMapping()
    public Booking createNewBooking(@RequestBody Booking booking){
      Booking newBooking = this.bookingRepository.save(booking);
      return newBooking;
    }

    @PutMapping("/{id}")
    public Booking updateDestination (@PathVariable("id") Integer id, 
    @RequestBody Booking b){
      Optional<Booking> bookingToUpdateOptional = this.bookingRepository.findById(id);
      if(!bookingToUpdateOptional.isPresent()){
        return null;
      }
      Booking bookingToUpdate = bookingToUpdateOptional.get();
 
      if(b.getUserId() != null ){
        bookingToUpdate.setUserId(b.getUserId());
      }
      if(b.getDestinationId() != null ){
        bookingToUpdate.setDestinationId(b.getDestinationId());
      }
      if(b.getBookingDate() != null ){
        bookingToUpdate.setBookingDate(b.getBookingDate());
      }
  
      Booking updatedBooking = this.bookingRepository.save(bookingToUpdate);
      return updatedBooking;
    }

    @DeleteMapping("/{id}")
    public Booking deleteBooking(@PathVariable("id") Integer id) {
      Optional<Booking> bookingToDeleteOptional = this.bookingRepository.findById(id);
      if (!bookingToDeleteOptional.isPresent()) {
        return null;
      }
      Booking bookingToDelete = bookingToDeleteOptional.get();
      this.bookingRepository.delete(bookingToDelete);
      return bookingToDelete;
    }
}
