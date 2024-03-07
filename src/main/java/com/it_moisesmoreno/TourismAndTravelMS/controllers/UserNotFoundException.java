package com.it_moisesmoreno.TourismAndTravelMS.controllers;

public class UserNotFoundException extends Throwable {
    public UserNotFoundException(String message){
        super(message);
    }
}
