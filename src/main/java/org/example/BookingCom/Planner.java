package org.example.BookingCom;

import org.example.BookingCom.transport.Transport;

import java.util.List;

public class Planner {
    List<Trip> tripList;
    List<Transport> transportList;

    public List<Trip> getTripList() {
        return tripList;
    }

    public void setTripList(List<Trip> tripList) {
        this.tripList = tripList;
    }

    public void addTransport(Transport transport) {
        transportList.add(transport);
    }
}
