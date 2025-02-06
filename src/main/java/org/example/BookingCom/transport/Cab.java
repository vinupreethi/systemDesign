package org.example.BookingCom.transport;

import org.example.BookingCom.Location;
import org.example.BookingCom.Vendor;

public class Cab implements Transport {
    private Vendor vendor;
    private String travelstartTime;
    private String travelendtime;
    private Location pickUpLocation;
    private Location dropLocation;
    private int capacity;

    public Cab(Vendor vendor, String travelstartTime, String travelendtime, Location pickUpLocation, Location dropLocation) {
        this.vendor = vendor;
        this.travelstartTime = travelstartTime;
        this.travelendtime= travelendtime;
        this.pickUpLocation = pickUpLocation;
        this.dropLocation =  dropLocation;
    }

    @Override
    public double transportCost() {
      return vendor.getPrice();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
