package org.example.BookingCom.transport;

import org.example.BookingCom.Location;
import org.example.BookingCom.Vendor;

public class FlightFactory implements TransportFactory{
    @Override
    public Transport chooseTransport(Vendor vendor, String travelstartDate, String travelendDate, Location departureLocation, Location arrivalLocation) {
        return new Flight(vendor,travelstartDate,travelendDate,departureLocation,arrivalLocation);
    }

}
