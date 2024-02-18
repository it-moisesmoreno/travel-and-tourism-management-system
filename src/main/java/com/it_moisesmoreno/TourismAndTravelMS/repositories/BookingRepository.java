package com.it_moisesmoreno.TourismAndTravelMS.repositories;

import java.util.List; 
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.it_moisesmoreno.TourismAndTravelMS.entities.Booking;



public interface BookingRepository extends CrudRepository<Booking, Integer> {
    List<Booking> findByUserIdAndDestinationId(Integer userId, Integer destinationId);
    List<Booking> findByBookingDateLessThan(Date bookingDate);
    List<Booking> findByBookingDateBetween(Date startDate, Date endDate);

    @Query(value="select * from bookings where CAST(BOOKING_DATE AS DATE) = :bookingDate", nativeQuery = true)
    List<Booking> findAllWithBookingDate(@Param("bookingDate") Date bookingDate);
}
