package org.example.AirlineManagement;

import java.time.LocalDate;
import java.util.List;

public class FlightScheduler implements Subject {
    private Flight flight;
    private String startLocation;
    private String endLocation;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Booking> bookings;

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }


    public FlightScheduler(Flight flight, String startLocation, String endLocation, LocalDate startDate, LocalDate endDate) {
        this.flight = flight;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public void addObserver(Booking booking) {
        bookings.add(booking);
    }

    @Override
    public void removeObserver(Booking booking) {
        bookings.remove(booking);
    }

    public void notifyAllPassengersAboutCancellation(List<Booking> bookings) {
        for (Booking booking : bookings) {
            booking.setBookingStatus(BookingStatus.CANCELLED);
            Passengers passengers=booking.getPassenger();
            passengers.updateBooking(booking);
        }
    }

    @Override
    public void notifyAllPassengersAboutRescheduler(List<Booking> bookingsList) {
        for (Booking booking : bookings) {
            booking.setBookingStatus(BookingStatus.RESCHEDULED);
            Passengers passengers=booking.getPassenger();
            passengers.updateBooking(booking);
        }

    }
}
