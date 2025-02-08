package org.example.AirlineManagement;

import java.time.LocalDate;
import java.util.List;

public class Booking  {
    private Flight flight;
    private Passengers passenger;
    private int bookingId;
    private LocalDate bookingDate;
    private Seat seat;
    private BookingStatus bookingStatus;

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Booking(Flight flight, Passengers passenger, Seat seat, int bookingId, LocalDate bookingDate) {
        this.flight = flight;
        this.passenger = passenger;
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.seat=seat;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passengers getPassenger() {
        return passenger;
    }

    public void setPassenger(Passengers passenger) {
        this.passenger = passenger;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }


}
