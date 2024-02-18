package com.it_moisesmoreno.TourismAndTravelMS.entities;

// Booking.java

import java.util.Date;

//import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import jakarta.persistence.Temporal;
//import jakarta.persistence.TemporalType;
import jakarta.persistence.Column;
//import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "destination_id")
    private Integer destinationId;

    @Column(name = "booking_date")
    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd' 'HH:mm:ss")
    //@Temporal(TemporalType.TIMESTAMP)
    private Date bookingDate;

     // Getters and setters

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDestinationId() {
        return this.destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    public Date getBookingDate() {
        return this.bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    // Constructor
    
    // Other methods as needed
}

