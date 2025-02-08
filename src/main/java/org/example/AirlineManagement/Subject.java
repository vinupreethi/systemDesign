package org.example.AirlineManagement;

import java.util.List;

public interface Subject {
   void addObserver(Booking booking);
    void removeObserver(Booking booking);
    void notifyAllPassengersAboutCancellation(List<Booking> bookingsList);
    void notifyAllPassengersAboutRescheduler(List<Booking> bookingsList);
}
