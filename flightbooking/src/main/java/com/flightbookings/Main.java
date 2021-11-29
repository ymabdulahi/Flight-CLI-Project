package com.flightbookings;

//import java.lang.reflect.Array;
import com.flightbookings.flights.*;
import com.flightbookings.passenger.NewPassenger;
import com.flightbookings.passenger.Passenger;
import com.flightbookings.services.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean exit = false;
        BookingSystem bookingSystem = new BookingSystem(2,2);
        Passenger passenger = null;
        System.out.println("Hello, Welcome to SkyScanner!");
        System.out.println("1: Login or 2: create new account (Please select 1 or 2)");
        Scanner scanner1 = new Scanner(System.in);
        String loginChoice = scanner1.nextLine();
        switch (loginChoice){
            case "1":
                FindPassenger passengerFind = new FindPassenger();
                System.out.println("Please enter passport number: ");
                Scanner scanner2 = new Scanner(System.in);
                String passportNumber = scanner1.nextLine();
                passenger = passengerFind.findPassenger(bookingSystem,passportNumber);
                break;
            case "2":
                NewPassenger newPassenger = new NewPassenger(bookingSystem);
                passenger = newPassenger.newPassenger();
                break;
            default:
                System.out.println("ERROR: Please type 1 or 2");
        }


        do {
            System.out.println("Welcome: " + passenger.getFirstName());
            System.out.println("Please choose a service: \n" +
                    "1: Look at flights \n" +
                    "2: Book Flight \n" +
                    "3: Cancel Flight\n" +
                    "4: Add Flight to SkyScanner\n" +
                    "5: Exit");
            Scanner scanner2 = new Scanner(System.in);
            String menu = scanner2.nextLine();
            switch (menu) {
                case "1":
                    ViewFlight viewFlight = new ViewFlight(bookingSystem, passenger);
                    viewFlight.flightMenu();
                    break;
                case "2":
                    BookFlight book = new BookFlight();
                    FindAvailableFlight available = new FindAvailableFlight();
                    System.out.println("Please enter flight number: ");
                    Scanner scanner3 = new Scanner(System.in);
                    String flightNumber = scanner3.nextLine();
                    Flight flight = available.findAvailableFlight(bookingSystem, Integer.parseInt(flightNumber));
                    book.bookFlight(passenger, flight, bookingSystem);
                    break;
                case "3":
                    CancelFlight cancel = new CancelFlight();
                    System.out.println("Please select a flight:");
                    for (int i = 0; i < 5; i++) {
                        if (passenger.getBookedFlights()[i] != null) {
                            System.out.println(i + 1 + ": " + passenger.getBookedFlights()[i]);
                        }
                    }
                    FindAvailableFlight cancelable = new FindAvailableFlight();
                    Scanner scanner4 = new Scanner(System.in);
                    String choiceNumber = scanner4.nextLine();
                    cancel.cancelFlight(passenger, passenger.getBookedFlights()[Integer.parseInt(choiceNumber) - 1], Integer.parseInt(choiceNumber));
                    break;
                case "4":
                    AddFlight addFlight = new AddFlight(bookingSystem);
                    addFlight.addFlight();
                    break;
                case "5":
                    exit = true;
                    break;

            }
        } while (!exit);


    }
}
