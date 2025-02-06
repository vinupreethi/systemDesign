package org.example.BookingCom.transport;

import org.example.BookingCom.Location;
import org.example.BookingCom.Vendor;

public class CabFactory implements TransportFactory {
    @Override
    public Transport chooseTransport(Vendor vendor, String travelstartDate, String travelendDate, Location departureLocation, Location arrivalLocation) {
        return new Cab(vendor,travelstartDate,travelendDate,departureLocation,arrivalLocation);
    }

}
