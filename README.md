#Flight_booking

Classes:

Flight:
Flight Number -->Look up how to specify we want digit number
Flight Company -->enum
Flight Start -->enum (airports)
Flight Destination -->enum (airports)
Flight Capacity --> int
Flight Departure Time -->LocalDateTime
Flight isFull --> boolean
Flight listOfPassengers --> Array[capacity]
Flight numOfPassengers -->int


Passenger:
First Name -->String
Last Name -->String
Passport Number -->Look up how to specify we want digit number 
DoB -->LocalDate
Citizenship -->ENUM
BookedFlights -->Array[AirportCapacity]

Identifier:
listOfAll Ids -->ArrayList
method: creates a new id

BookingSystem:
FlightAvailable -->Array[AirportCapacity]
FullyBookedFlights -->Array[AirportCapacity]
AllFlights -->Array[AirportCapacity] 
Airport Capacity --> int

FlightManagerService:
BookFlight
CancelFlight
ViewFlightsAvailable
ViewFullyBookedFlights (all)
ViewBookedFlights (passenger)
AddNewFlight
NewPassenger



