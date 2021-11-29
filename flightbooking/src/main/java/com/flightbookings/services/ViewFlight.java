package com.flightbookings.services;

import com.flightbookings.flights.Flight;
import com.flightbookings.passenger.Passenger;

import java.util.Arrays;
import java.util.Scanner;

public class ViewFlight {

    private BookingSystem bookingSystem;
    private Passenger passengerFlight;

    public ViewFlight(BookingSystem bookingSystem, Passenger passengerFlight) {
        this.bookingSystem = bookingSystem;
        this.passengerFlight = passengerFlight;
    }



    public void flightMenu(){



        System.out.println("Enter: Available flights, fully booked flights, my flights or exit");
        Scanner input = new Scanner(System.in);


        while(true){
            String flightInput = input.nextLine();

            if (flightInput.equalsIgnoreCase("Available flights")) {
                System.out.println(Arrays.toString(bookingSystem.getFlightsAvailable()));
                System.out.println("Please press enter to go back to the main menu");
            } else if(flightInput.equalsIgnoreCase("Fully booked flights")) {
                System.out.println(Arrays.toString(bookingSystem.getFullyBookedFlights()));
                System.out.println("Please press enter to go back to the main menu");
            } else if(flightInput.equalsIgnoreCase("My flights")) {
//                System.out.println(Arrays.toString(passengerFlight.getBookedFlights()));
                for (Flight bookedFlight : passengerFlight.getBookedFlights()) {
                    System.out.println(bookedFlight);
                }
                System.out.println("Please press enter to go back to the main menu");
            } else if (flightInput.equalsIgnoreCase("Exit")){
                System.out.println("Goodbye");
                break;
            } else if (flightInput.equals("")) {
                System.out.println("Enter: Available flights, fully booked flights, my flights or exit");
            }
            else {
                System.out.println("Error: please try again");
                System.out.println("Enter: Available flights, fully booked flights, my flights or exit");


            }

        }

    }


}

