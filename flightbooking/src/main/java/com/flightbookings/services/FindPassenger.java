package com.flightbookings.services;

import com.flightbookings.passenger.Passenger;
import com.flightbookings.services.BookingSystem;

public class FindPassenger {
    public Passenger findPassenger(BookingSystem bookingSystem, String passportNumber){
        Passenger[] allPassengers = bookingSystem.getAllPassengers();
        Passenger passenger = null;
        for (Passenger passengerLoop : allPassengers){
            if (passengerLoop.getPassportNumber() == passportNumber){
                passenger = passengerLoop;
                break;
            }
        }
        return passenger;
    }
}
