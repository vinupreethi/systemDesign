package org.example.AirlineManagement;

import org.example.AirlineManagement.payment.BalanceInsuffice;
import org.example.AirlineManagement.payment.CreditCardStrategy;
import org.example.AirlineManagement.search.DateSearchStrategy;
import org.example.AirlineManagement.search.LocationSearchStrategy;
import org.example.AirlineManagement.search.SearchContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
The airline management system should allow users to search for flights based on source, destination, and date.
Users should be able to book flights, select seats, and make payments.
The system should manage flight schedules, aircraft assignments.
The system should handle passenger information, including personal details and baggage information.
The system should support different types of users, such as passengers, airline staff, and administrators.
The system should be able to handle cancellations, refunds, and flight changes.
The system should ensure data consistency and handle concurrent access to shared resources.
The system should be scalable and extensible to accommodate future enhancements and new features.
 */
public class AirlineBookingSystem {

    public static void main(String args[]) throws BookingNotDoneException, BalanceInsuffice {
        List<FlightScheduler> flightSchedulers = new ArrayList<>();
        initializeAirlineBookingSystem(flightSchedulers);
        Passengers passenger = new Passengers();

        SearchContext searchContext = new SearchContext(new LocationSearchStrategy("Paris", "London"));
        List<Flight> flightList = searchContext.doSearch(flightSchedulers);

        SearchContext searchContext1 = new SearchContext(new DateSearchStrategy(LocalDate.of(2022, 03, 01), LocalDate.of(2022, 03, 03)));
        List<Flight> flightList1 = searchContext.doSearch(flightSchedulers);


        Flight flight = flightList1.get(0);
        /****** Book flight *********/
        Booking booking = bookFlight(flight, passenger);

        /****** Add flights **********/
        List<Seat> seats = new ArrayList<>();
        AirCraft airCraft = new AirCraft();
        Flight flight4 = new Flight(1, seats, airCraft);
        FlightScheduler flightScheduler = new FlightScheduler(flight4, "Paris", "London", LocalDate.of(2022, 03, 01), LocalDate.of(2022, 03, 03));
        flightSchedulers.add(flightScheduler);


        /****** Remove flights ********/
        Flight flight5 = new Flight(1, seats, airCraft);
        FlightScheduler flightScheduler1 = new FlightScheduler(flight5, "Paris", "London", LocalDate.of(2022, 03, 01), LocalDate.of(2022, 03, 03));
        flightSchedulers.remove(flightScheduler1);

        /*************** Flight cancellation & refunds ****************/
       // cancelFlight(flight4, flightSchedulers);

        /*************** Flight reschedule ****************/
        Flight flight3 = new Flight(1, seats, airCraft);
        rescheduleFlight(flight3,flightScheduler1, flightSchedulers);


        /*************** Cancelling tickets by passenger ****************/

    }

    private static void rescheduleFlight(Flight flight5,FlightScheduler flightScheduler1, List<FlightScheduler> flightScheduler) {
        List<Booking> bookings = flightScheduler1.getBookings();
        for (FlightScheduler flight : flightScheduler) {
            if (flight.getFlight().getFlightId() == flight5.getFlightId()) {
                flightScheduler.remove(flight);
            }
        }
        flightScheduler.add(flightScheduler1);
        flightScheduler1.notifyAllPassengersAboutRescheduler(bookings);
    }


//    private static void cancelFlight(Flight flight5, List<FlightScheduler> flightScheduler) {
//        FlightScheduler flightDetail = flight5.getflightScheduler();
//        List<Booking> bookings = flightDetail.getBookings();
//        flightScheduler.remove(flightDetail);
//        flightDetail.notifyAllPassengersAboutCancellation(bookings);
//
//
//    }

    private static synchronized Booking bookFlight(Flight flight, Passengers passenger) throws BookingNotDoneException, BalanceInsuffice {
        Seat seat = new Seat();
        seat.setSeatId(123);
        Booking booking = new Booking(flight, passenger, seat, new Random().nextInt(111) + 999, LocalDate.now());
        if (passenger.makePayment(seat.getPrice(), new CreditCardStrategy())) {
            booking.setBookingStatus(BookingStatus.BOOKED);
            seat.setSeatStatus(SeatStatus.OCCUPIED);
            //  booking.addObserver(flight,passenger);

            return booking;
        } else
            throw new BookingNotDoneException("booking is not done");

    }


    private static void initializeAirlineBookingSystem(List<FlightScheduler> flightSchedulers) {
        List<Seat> seats = new ArrayList<>();
        AirCraft airCraft = new AirCraft();
        Flight flight = new Flight(1, seats, airCraft);
        FlightScheduler flightScheduler = new FlightScheduler(flight, "Paris", "London", LocalDate.of(2022, 03, 01), LocalDate.of(2022, 03, 03));
        Flight flight1 = new Flight(1, seats, airCraft);
        FlightScheduler flightScheduler2 = new FlightScheduler(flight1, "Paris", "London", LocalDate.of(2022, 03, 01), LocalDate.of(2022, 03, 03));
        Flight flight2 = new Flight(1, seats, airCraft);
        FlightScheduler flightScheduler3 = new FlightScheduler(flight2, "Paris", "London", LocalDate.of(2022, 03, 01), LocalDate.of(2022, 03, 03));
        flightSchedulers.add(flightScheduler);
        flightSchedulers.add(flightScheduler2);
        flightSchedulers.add(flightScheduler3);

    }


}
