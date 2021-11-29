package com.flightbookings.services;

import com.flightbookings.flights.Flight;
import com.flightbookings.passenger.Passenger;

import java.util.Arrays;

public class BookingSystem {
    private Flight[] flightsAvailable;
    private Flight[] fullyBookedFlights;
    private Flight[] allFlights;
    private Passenger[] allPassengers;
    private int systemCapacity;
    private int flightCount;
    private int availableCount;
    private int bookedCount;
    private int passengerCapacity;
    private int passengerCount;

    public BookingSystem(int systemCapacity, int passengerCapacity) {
        this.flightsAvailable = new Flight[systemCapacity];
        this.fullyBookedFlights = new Flight[systemCapacity];
        this.allFlights = new Flight[systemCapacity];
        this.allPassengers = new Passenger[passengerCapacity];
        this.systemCapacity = systemCapacity;
        this.passengerCapacity = passengerCapacity;
        this.flightCount = 0;
        this.passengerCount = 0;
        this.bookedCount = 0;
        this.availableCount = 0;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }

    public int getBookedCount() {
        return bookedCount;
    }

    public void setBookedCount(int bookedCount) {
        this.bookedCount = bookedCount;
    }

    public int getFlightCount() {
        return flightCount;
    }

    public void setFlightCount(int flightCount) {
        this.flightCount = flightCount;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public Passenger[] getAllPassengers() {
        return allPassengers;
    }

    public void setAllPassengers(Passenger[] allPassengers) {
        this.allPassengers = allPassengers;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public Flight[] getFlightsAvailable() {
        return flightsAvailable;
    }

    public void setFlightsAvailable(Flight[] flightsAvailable) {
        this.flightsAvailable = flightsAvailable;
    }

    public Flight[] getFullyBookedFlights() {
        return fullyBookedFlights;
    }

    public void setFullyBookedFlights(Flight[] fullyBookedFlights) {
        this.fullyBookedFlights = fullyBookedFlights;
    }

    public Flight[] getAllFlights() {
        return allFlights;
    }

    public void setAllFlights(Flight[] allFlights) {
        this.allFlights = allFlights;
    }

    public int getSystemCapacity() {
        return systemCapacity;
    }

    public void setSystemCapacity(int systemCapacity) {
        this.systemCapacity = systemCapacity;
    }

    @Override
    public String toString() {
        return "BookingSystem{" +
                "flightsAvailable=" + Arrays.toString(flightsAvailable) +
                ", fullyBookedFlights=" + Arrays.toString(fullyBookedFlights) +
                ", allFlights=" + Arrays.toString(allFlights) +
                ", allPassengers=" + Arrays.toString(allPassengers) +
                ", systemCapacity=" + systemCapacity +
                ", flightCount=" + flightCount +
                ", passengerCapacity=" + passengerCapacity +
                ", passengerCount=" + passengerCount +
                '}';
    }
}
