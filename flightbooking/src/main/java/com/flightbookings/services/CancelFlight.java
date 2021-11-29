package com.flightbookings.services;

import com.flightbookings.flights.Flight;
import com.flightbookings.passenger.Passenger;

public class CancelFlight {
    public void cancelFlight(Passenger passenger, Flight flight, int index) {
        Passenger[] passengerList = flight.getListOfPassengers();
        int passengerLength = passengerList.length;
        for (int i = 0; i < passenger.getCount(); i++) {
            if (flight.getListOfPassengers()[i].getId().equals(passenger.getId())) {
                flight.getListOfPassengers()[i] = null;
                passenger.getBookedFlights()[index - 1] = null;
                int count = flight.getNumOfPassengers();
                int num = passenger.getCount();
                passenger.setCount(++num);
                flight.setNumOfPassengers(--count);
                System.out.println("Flight Cancelled");
                break;
            }
        }
    }
}
