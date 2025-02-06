package org.example.BookingCom.transport;

import org.example.BookingCom.Location;
import org.example.BookingCom.Vendor;

public interface TransportFactory {
    Transport chooseTransport(Vendor vendor, String travelstartDate, String travelendDate, Location departureLocation, Location arrivalLocation);
}
