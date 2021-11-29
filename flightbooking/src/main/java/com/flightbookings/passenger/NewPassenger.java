package com.flightbookings.passenger;

import com.flightbookings.services.BookingSystem;

import javax.swing.*;
import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Scanner;

public class NewPassenger {
    private BookingSystem bookingSystem;
    private static final Locale defaultFormattingLocale
            = Locale.getDefault(Locale.Category.FORMAT);
    private static final String defaultDateFormat = DateTimeFormatterBuilder
            .getLocalizedDateTimePattern(FormatStyle.SHORT, null,
                    IsoChronology.INSTANCE, defaultFormattingLocale);
    private static final DateTimeFormatter dateFormatter
            = DateTimeFormatter.ofPattern("dd/MM/uuuu");
    public static LocalDate userInputDOB(){
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Enter date in " + "dd/mm/yyyy" );
        String dateString = inputScanner.nextLine();
        LocalDate inputDate = null;
        try{
            inputDate = LocalDate.parse(dateString, dateFormatter);
            System.out.println("Date entered was " + inputDate);

        } catch(DateTimeParseException dtpe){
            System.out.println("Invalid date: " + dateString);
            userInputDOB();
        }
        return inputDate;
    }
    public NewPassenger(BookingSystem bookingSystem){
        this.bookingSystem = bookingSystem;
    }
    public Passenger newPassenger(){
        System.out.println("Enter First Name: ");
        Scanner scanner1 = new Scanner(System.in);
        String firstName = scanner1.nextLine();

        System.out.println("Enter Last Name: ");
        Scanner scanner2 = new Scanner(System.in);
        String lastName = scanner2.nextLine();

        String passportNumber = null;
        do{
            System.out.println("Enter Passport Number (6 digits): ");
            Scanner scanner3 = new Scanner(System.in);
            passportNumber = scanner3.nextLine();
        } while (passportNumber.length() != 6);


        LocalDate inputDate = userInputDOB();

        System.out.println("Enter Citizenship:");
        Object selection = JOptionPane.showInputDialog(null,
                "Choose a Citizenship", "Citizenship",
                JOptionPane.INFORMATION_MESSAGE, null,
                Citizenship.values(), Citizenship.values()[0]);
        Citizenship citizenship = Citizenship.valueOf(selection.toString());

        // check that selection is not null before using
        System.out.println(selection);

        if (bookingSystem.getPassengerCount()+1 <= bookingSystem.getPassengerCapacity()) {
            Passenger passenger = new Passenger(firstName, lastName, passportNumber, inputDate, citizenship);
            bookingSystem.getAllPassengers()[bookingSystem.getPassengerCount()] = passenger;
            int count = bookingSystem.getPassengerCount();
            bookingSystem.setPassengerCount(++count);
            System.out.println(passenger.toString());
            return passenger;
        } else{
            System.out.println("Sorry System is full!");
            return null;
        }

    }
}
