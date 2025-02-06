package org.example.BookingCom;

public class Vendor {
    private String vendorName;
    private double price;

    public Vendor(String vendorName, double price) {
        this.vendorName = vendorName;
        this.price = price;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
