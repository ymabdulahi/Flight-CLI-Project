package com.flightbookings.flights;

import com.flightbookings.flights.Airport;
import com.flightbookings.flights.Company;
import com.flightbookings.passenger.Passenger;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Flight {
    private int flightNumber;
    private Company flightCompany;
    private Airport startPoint;
    private Airport destination;
    private int capacity;
    private LocalDateTime departureTime;
    private boolean isFull;
    private Passenger[] listOfPassengers;
    private int numOfPassengers;

    public Flight(int flightNumber, Company flightCompany, Airport startPoint, Airport destination, int capacity, LocalDateTime departureTime) {
        this.flightNumber = flightNumber;
        this.flightCompany = flightCompany;
        this.startPoint = startPoint;
        this.destination = destination;
        this.capacity = capacity;
        this.departureTime = departureTime;
        this.isFull = false;
        this.listOfPassengers = new Passenger[capacity];
        this.numOfPassengers = 0;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Company getFlightCompany() {
        return flightCompany;
    }

    public void setFlightCompany(Company flightCompany) {
        this.flightCompany = flightCompany;
    }

    public Airport getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Airport startPoint) {
        this.startPoint = startPoint;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public Passenger[] getListOfPassengers() {
        return listOfPassengers;
    }

    public void setListOfPassengers(Passenger[] listOfPassengers) {
        this.listOfPassengers = listOfPassengers;
    }

    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(int numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber=" + flightNumber +
                ", flightCompany=" + flightCompany +
                ", startPoint=" + startPoint +
                ", destination=" + destination +
                ", capacity=" + capacity +
                ", departureTime=" + departureTime +
                ", isFull=" + isFull +
                ", listOfPassengers=" + Arrays.toString(listOfPassengers) +
                ", numOfPassengers=" + numOfPassengers +
                '}';
    }
}
