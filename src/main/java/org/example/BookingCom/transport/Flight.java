package org.example.BookingCom.transport;

import org.example.BookingCom.Location;
import org.example.BookingCom.Vendor;

public class Flight implements Transport {
    private Vendor vendor;
    private String travelstartDate;
    private String travelendDate;
    private Location departureLocation;
    private Location arrivalLocation;
    private String seatNo;
    private int capacity;


    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Flight(Vendor vendor, String travelstartDate, String travelendDate, Location departureLocation, Location arrivalLocation) {
        this.vendor = vendor;
        this.travelstartDate = travelstartDate;
        this.travelendDate = travelendDate;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
    }

    @Override
    public double transportCost() {
       return vendor.getPrice();
    }


}
