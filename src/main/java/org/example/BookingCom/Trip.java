package org.example.BookingCom;

import org.example.BookingCom.transport.Cab;
import org.example.BookingCom.transport.Flight;
import org.example.BookingCom.transport.Transport;

import java.util.ArrayList;
import java.util.List;

public class Trip {
    List<Transport> transportList=new ArrayList<>();
    List<Hotel> hotelList=new ArrayList<>();

    public List<Transport> getTransportList() {
        return transportList;
    }

    public void setTransportList(List<Transport> transportList) {
        this.transportList = transportList;
    }

    public List<Hotel> getHotelList() {
        return hotelList;
    }

    public void setHotelList(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }

    public void addFlight(Flight flight1) {
        transportList.add(flight1);
    }

    public void addHotel(Hotel hotel1) {
        hotelList.add(hotel1);
    }

    public void addCab(Cab cab1) {
        transportList.add(cab1);
    }

    public double getTotalPrice( List<Hotel> hotelList,List<Transport> transportList) {
       double cost=0;
        for(Transport transport: transportList)
        {
            cost+=transport.transportCost();
        }
        for(Hotel hotel: hotelList)
        {
            cost+=hotel.getChosenRoom().getPrice();
        }
        return cost;
    }
}
