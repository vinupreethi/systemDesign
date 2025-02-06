package org.example.BookingCom;

import org.example.BookingCom.bookingService.HotelBookingService;
import org.example.BookingCom.bookingService.TransportBookingService;
import org.example.BookingCom.payment.CreditCardPayment;
import org.example.BookingCom.transport.Cab;
import org.example.BookingCom.transport.Flight;
import org.example.BookingCom.transport.Transport;

import java.util.ArrayList;
import java.util.List;

public class BookingService {
    public static void main(String args[]) throws Exception {
        try {
            Customer customer=new Customer("vinu","919999999","vinu@gmail.com");
            Planner planner=customer.getPlanner();
            List<Trip> tripList = planner.getTripList();
            Trip trip = new Trip();

            List<Hotel> triphotelList = new ArrayList<>();
            List<Transport> tripTransportList = new ArrayList<>();

            String travelstartDate = "20-Feb";
            String travelendDate = "21-Feb";
            String startTime = "10 am";
            String endTime = "11 am";
            Location sourceLocation = new Location("Chennai", "India");
            Location destinationLocation = new Location("Bangkok", "Thailand");
            int noOfPersons = 2;
            /**  Booking flight  **/
            TransportBookingService transportBookingService = new TransportBookingService(travelstartDate, travelendDate, startTime, endTime, sourceLocation, destinationLocation);
            Flight flight1 = transportBookingService.bookFlight(noOfPersons);
            trip.addFlight(flight1);


            /**  Booking hotel  **/
            Location location = new Location("mumbai", "India");
            List<Hotel> hotelList = location.getHotelList();
            String hotelName = "TAJ";
            Hotel chosenHotel = null;
            for (Hotel hotel : hotelList) {
                if (hotel.getHotelName().equals(hotelName)) {
                    chosenHotel = hotel;
                }
            }
            HotelBookingService hotelBookingService = new HotelBookingService(destinationLocation, "21-Feb", "24-Feb", 1000);
            Hotel hotel1 = hotelBookingService.reserveRoominHotel(chosenHotel, new Room("Delux", 2));
            trip.addHotel(hotel1);

            /*** Booking cab **/
            Location sourceLocationCab = new Location("Bangkok", "Thailand");
            Location destinationLocationCab = new Location("Rayong", "Thailand");
            Cab cab1 = transportBookingService.bookCab(noOfPersons, "9am ", "10am", sourceLocationCab, destinationLocationCab);
            trip.addCab(cab1);

            /** Booking flight **/
            sourceLocation = new Location("Rayong", "Thailand");
            destinationLocation = new Location("Chennai", "India");
            travelstartDate = "22-Feb";
            travelendDate = "23-Feb";
            transportBookingService = new TransportBookingService(travelstartDate, travelendDate, "10am", "11am", sourceLocation, destinationLocation);
            Flight flight2 = transportBookingService.bookFlight(noOfPersons);
            trip.addFlight(flight2);

            triphotelList.add(hotel1);
            tripTransportList.add(flight2);
            tripTransportList.add(flight1);
            double price = trip.getTotalPrice(triphotelList, tripTransportList);
            tripList.add(trip);
            customer.makePayment(new CreditCardPayment(),price);
        } catch (Exception e) {
            System.out.println("booking cannot be done..!");
        }


    }


}
