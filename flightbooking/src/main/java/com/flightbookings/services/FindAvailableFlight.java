package com.flightbookings.services;

import com.flightbookings.flights.Flight;
import com.flightbookings.services.BookingSystem;

public class FindAvailableFlight {
    public Flight findAvailableFlight(BookingSystem bookingSystem, int flightNumber){
        Flight[] availableFlights = bookingSystem.getFlightsAvailable();
        Flight flight = null;
        for (Flight flightLoop : availableFlights){
            if (flightLoop.getFlightNumber() == flightNumber){
                flight = flightLoop;
                break;
            }
        }
        return flight;
    }
}