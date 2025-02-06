package org.example.BookingCom.bookingService;

import org.example.BookingCom.Location;
import org.example.BookingCom.Vendor;
import org.example.BookingCom.transport.Cab;
import org.example.BookingCom.transport.Flight;

public class TransportBookingService {
    String startTime;
    String endTime;
    String travelStartDate;
    String travelendDate;
    Location sourceLocation;
    Location destinationLocation;

    public TransportBookingService(String startTime, String endTime, String travelstartDate, String travelendDate, Location sourceLocation, Location destinationLocation) {
        this.travelStartDate = travelstartDate;
        this.travelendDate = travelendDate;
        this.sourceLocation = sourceLocation;
        this.destinationLocation = destinationLocation;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Flight bookFlight(int noOfPersons) throws Exception {
        Vendor vendor = new Vendor("indigo", 10000);
        Flight transport = new Flight(vendor, travelStartDate, travelendDate, sourceLocation, destinationLocation);
        if (transport.getCapacity() - noOfPersons >= 0)
            transport.setCapacity(transport.getCapacity() - noOfPersons);
        else
            throw new Exception();
        return transport;
    }

    public Cab bookCab(int noOfPersons, String startTime, String endTime, Location sourceLocation, Location destinationLocation) throws Exception {
        Vendor vendor = new Vendor("travels", 10000);
        Cab transport = new Cab(vendor, startTime, endTime, sourceLocation, destinationLocation);
        if (transport.getCapacity() - noOfPersons >= 0)
            transport.setCapacity(transport.getCapacity() - noOfPersons);
        else
            throw new Exception();
        return transport;
    }


}
