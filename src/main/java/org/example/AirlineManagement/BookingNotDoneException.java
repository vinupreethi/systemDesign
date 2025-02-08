package org.example.AirlineManagement;

public class BookingNotDoneException extends Throwable {
    public BookingNotDoneException(String bookingIsNotDone) {
        super(bookingIsNotDone);
    }
}
