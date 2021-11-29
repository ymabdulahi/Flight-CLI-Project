package com.flightbookings.services;

import com.flightbookings.flights.Airport;
import com.flightbookings.flights.Company;
import com.flightbookings.flights.Flight;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Scanner;

public class AddFlight {
    private BookingSystem bookingSystem;
    public AddFlight(BookingSystem bookingSystem){
        this.bookingSystem = bookingSystem;
    }
    private static final Locale defaultFormattingLocale
            = Locale.getDefault(Locale.Category.FORMAT);
    private static final String defaultDateFormat = DateTimeFormatterBuilder
            .getLocalizedDateTimePattern(FormatStyle.SHORT, null,
                    IsoChronology.INSTANCE, defaultFormattingLocale);
    private static final DateTimeFormatter dateFormatter
            = DateTimeFormatter.ofPattern("HH:mm dd/MM/uuuu");
    public void addFlight(){
        System.out.println("Enter Flight Number: ");
        Scanner scanner1 = new Scanner(System.in);
        String flightNumber = scanner1.nextLine();

        System.out.println("Enter Flight Company: ");
        Object selection = JOptionPane.showInputDialog(null,
                "Choose a Company", "Company",
                JOptionPane.INFORMATION_MESSAGE, null,
                Company.values(), Company.values()[0]);
        Company flightCompany= Company.valueOf(selection.toString());
        System.out.println(flightCompany);

        System.out.println("Enter Start Point: ");
        Object selection2 = JOptionPane.showInputDialog(null,
                "Choose Start Point", "Start Point",
                JOptionPane.INFORMATION_MESSAGE, null,
                Airport.values(), Airport.values()[0]);
        Airport startPoint= Airport.valueOf(selection2.toString());
        System.out.println(startPoint);

        System.out.println("Enter Destination: ");
        Object selection3 = JOptionPane.showInputDialog(null,
                "Choose an Destination", "Destination",
                JOptionPane.INFORMATION_MESSAGE, null,
                Airport.values(), Airport.values()[0]);
        Airport destination= Airport.valueOf(selection3.toString());
        System.out.println(destination);

        System.out.println("Enter Flight Capacity");
        Scanner scanner2 = new Scanner(System.in);
        String flightCapacity = scanner2.nextLine();

        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Enter date in " + "hh:mm dd/mm/yyyy" );
        String dateString = inputScanner.nextLine();
        LocalDateTime inputDate = null;
        inputDate = LocalDateTime.parse(dateString, dateFormatter);
        System.out.println("Date entered was " + inputDate);


        if (bookingSystem.getFlightCount()+1 <= bookingSystem.getSystemCapacity()) {
            Flight flight = new Flight(Integer.parseInt(flightNumber), flightCompany, startPoint, destination, Integer.parseInt(flightCapacity),inputDate);
            bookingSystem.getAllFlights()[bookingSystem.getFlightCount()] = flight;
            bookingSystem.getFlightsAvailable()[bookingSystem.getFlightCount()] = flight;
            int count = bookingSystem.getFlightCount();
            int num = bookingSystem.getAvailableCount();
            bookingSystem.setAvailableCount(++num);
            bookingSystem.setFlightCount(++count);
            System.out.println(bookingSystem.toString());
        } else{
            System.out.println("Sorry System is full!");
        }
    }
}
